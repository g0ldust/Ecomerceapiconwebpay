package com.pcfactory.ecommerce.controller;

import com.pcfactory.ecommerce.dto.Category;
import com.pcfactory.ecommerce.dto.Meal;
import com.pcfactory.ecommerce.service.MealService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @GetMapping("/categories")
    public Mono<List<Category>> getCategories() {
        return mealService.getCategories();
    }

    @GetMapping("/byname/search")
    public Mono<List<Meal>> searchMeal(@RequestParam(value = "s", defaultValue = "Arrabiata") String mealName){
        return mealService.searchMealByName(mealName);
    }
    @GetMapping("/byletter/search")
    public Mono<List<Meal>> searchMealByLetter(@RequestParam(name = "f", defaultValue = "a") String firstLetter) {
        return mealService.searchMealByFirstLetter(firstLetter);
    }

    @GetMapping("/random")
    public Mono<List<Meal>> getRandomMeal(){
        return mealService.getRandomMeal();
    }
}