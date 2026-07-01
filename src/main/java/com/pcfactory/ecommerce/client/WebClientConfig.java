package com.pcfactory.ecommerce.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${webpay.base-url}")
    private String webpayBaseUrl;

    @Value("${webpay.commerce-code}")
    private String commerceCode;

    @Value("${webpay.api-key}")
    private String apiKey;

    @Bean
    public WebClient mealDbWebClient() {
        return WebClient.builder().baseUrl("https://themealdb.com").build();
    }

    @Bean
    public WebClient webpayWebClient() {
        return WebClient.builder()
                .baseUrl(webpayBaseUrl)
                .defaultHeader("Tbk-Api-Key-Id", commerceCode)
                .defaultHeader("Tbk-Api-Key-Secret", apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}