package com.HyperLocal_Inventory.Loaction_Service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerCoustomization(){
        return new OpenAPI()
                .info(
                        new Info().title("Location_Service APIs")
                                .description(" For Location Management Of All Users")
                ).tags(List.of(
                                new Tag().name("1. Location_CRU APIs"),
                                new Tag().name("2. Search APIs")
                        )
                );

    }
}
