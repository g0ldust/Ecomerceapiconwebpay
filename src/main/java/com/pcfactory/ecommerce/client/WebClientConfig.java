package com.pcfactory.ecommerce.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient mealDbWebClient() {
        return WebClient.builder()
                .baseUrl("https://themealdb.com")
                .build();
    }
}