package com.pcfactory.ecommerce.service;

import com.pcfactory.ecommerce.dto.Category;
import com.pcfactory.ecommerce.dto.CategoryResponse;
import com.pcfactory.ecommerce.dto.Meal;
import com.pcfactory.ecommerce.dto.MealResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MealService {

    private final WebClient webClient;

    public MealService(@Qualifier("mealDbWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<Category>> getCategories() {
        return this.webClient.get()
                .uri("/api/json/v1/1/categories.php")
                .retrieve()
                .bodyToMono(CategoryResponse.class)
                .map(CategoryResponse::getCategories);
    }



    public Mono<List<Meal>> searchMealByName(String name){
        return this.webClient.get()
                        .uri(uriBuilder -> uriBuilder
                        .path("/api/json/v1/1/search.php")
                        .queryParam("s", name)
                        .build())
                .retrieve()
                .bodyToMono(MealResponse.class)
                .map(MealResponse:: getMeals);
    }

    public Mono<List<Meal>> searchMealByFirstLetter(String firstLetter) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/json/v1/1/search.php")
                        .queryParam("f", firstLetter)
                        .build())
                .retrieve()
                .bodyToMono(MealResponse.class)
                .map(MealResponse::getMeals);
    }

    public Mono<List<Meal>> getRandomMeal(){
        return this.webClient.get()
                .uri("/api/json/v1/1/random.php")
                .retrieve()
                .bodyToMono(MealResponse.class)
                .map(MealResponse::getMeals);

    }
}