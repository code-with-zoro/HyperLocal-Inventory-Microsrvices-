package com.HyperLocal_Inventory.User_Auth_Service.config;
import com.HyperLocal_Inventory.User_Auth_Service.filter.JwtFilter;
import com.HyperLocal_Inventory.User_Auth_Service.services.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final UserDetailServiceImpl userDetailService;
    private final JwtFilter jwtFilter;

    public SpringSecurity(UserDetailServiceImpl userDetailService, JwtFilter jwtFilter) {
        this.userDetailService = userDetailService;
        this.jwtFilter = jwtFilter;
    }

    @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
   }

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
   http.csrf(csrf -> csrf.disable()
           ).authorizeHttpRequests(auth -> auth
                   .requestMatchers("/auth/**").authenticated()
                   .requestMatchers("/admin/**").hasRole("ADMIN")
                   .requestMatchers("/vendor/**").hasRole("VENDOR")
                   .anyRequest().permitAll()
                  );
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
   http.addFilterBefore(jwtFilter , UsernamePasswordAuthenticationFilter.class);
   return http.build();
   }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }
}
