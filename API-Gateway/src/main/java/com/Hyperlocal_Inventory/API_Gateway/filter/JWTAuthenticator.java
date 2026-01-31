package com.Hyperlocal_Inventory.API_Gateway.filter;

import com.Hyperlocal_Inventory.API_Gateway.exceptions.MissingAuthorizarionHeader;
import com.Hyperlocal_Inventory.API_Gateway.exceptions.UnAuthorizeAccessException;
import com.Hyperlocal_Inventory.API_Gateway.utils.JwtUtil;
import com.Hyperlocal_Inventory.API_Gateway.validator.RouteValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticator
        extends AbstractGatewayFilterFactory<JWTAuthenticator.Config> {

    private static final Logger log = LoggerFactory.getLogger(JWTAuthenticator.class);
    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    public JWTAuthenticator() {
        super(Config.class);
    }

    public static class Config {
        // empty for now
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();

            if (routeValidator.isSecured.test(request)) {

                if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                String authHeader = request.getHeaders()
                        .getFirst(HttpHeaders.AUTHORIZATION);

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                String token = authHeader.substring(7);

                try {
                    jwtUtil.validateToken(token);

                    String userId = jwtUtil.extractUserId(token);

                    request = request.mutate()
                            .header("LoggedInUserId", userId)
                            .build();

                } catch (Exception e) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }

            return chain.filter(exchange.mutate().request(request).build());
        };
    }
}