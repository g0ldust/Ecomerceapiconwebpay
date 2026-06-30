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
                .baseUrl("https://webpay3gint.transbank.cl")
                .defaultHeader("Tbk-Api-Key-Id", "597055555532")
                .defaultHeader("Tbk-Api-Key-Secret", "579B532A7440BB0C9079DED94D31EA1615B1C566875DE8C22485800D93E3324E")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}