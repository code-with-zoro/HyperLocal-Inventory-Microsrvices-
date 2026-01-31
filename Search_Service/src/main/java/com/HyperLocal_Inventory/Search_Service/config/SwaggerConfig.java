package com.HyperLocal_Inventory.Search_Service.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI SwaggerCustomization(){
        return new OpenAPI()
                .info(new Info().title("Search_Service APIs")
                        .description("APIs for Searching Of Product")
                )
                .tags(List.of(
                        new Tag().name("1. Product_Search APIs")
                ));
    }
}
