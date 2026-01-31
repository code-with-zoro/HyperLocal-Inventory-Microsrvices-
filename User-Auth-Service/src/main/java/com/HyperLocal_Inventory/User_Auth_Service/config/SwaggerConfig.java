package com.HyperLocal_Inventory.User_Auth_Service.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerCoustomization(){
        return new OpenAPI()
                .info(
                        new Info().title("User_Auth_Service APIs")
                                .description(" For User Signup & Login ")
                ).tags(List.of(
                        new Tag().name("1. Public APIs")
                                .description(" Non Authenticated APIs For User to Signup and Login"),

                        new Tag().name("2. Authenticated APIs")
                                .description(" Authenticated APIs For User to Update Update Details and Delete User"),
                        new Tag().name("3. Role Based APIs - Admin")
                                .description(" Authenticated API For Admin , Only to Read All Users Non Confidential Details And Server Health Check"),

                        new Tag().name("4. Role Based APIs - Vendor")
                                .description(" Authenticated APIs For Vendors only , To Read His Inventory Details")

                )
                );

    }
}
