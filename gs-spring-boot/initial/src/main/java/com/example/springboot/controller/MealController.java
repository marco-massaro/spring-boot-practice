package com.example.springboot.controller;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.entity.Ingredient;
import com.example.springboot.entity.Meal;
import com.example.springboot.service.MealService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private MealService mealService;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealController(MealService mealService, RestaurantConfig restaurantConfig) {
        this.mealService = mealService;
        this.restaurantConfig = restaurantConfig;
    }

    @GetMapping("/restaurant-config")
    public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
        return ResponseEntity.ok(restaurantConfig);
    }
    @GetMapping("/get/meals")
    public ResponseEntity<?> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/put/meals")
    public ResponseEntity<?> putMeals(@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeals(@PathVariable Long mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("meal deleted");
    }

    @PostMapping("/meal")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal){
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @PostMapping("/meal-many-to-one")
    public ResponseEntity<Meal> mealManyToOne(){
        Meal meal = new Meal("Xialongbao", "Soup Dumplings", 10.0, true, false); //???
        Ingredient ingredient = new Ingredient("Dumpling",true,true,false,true);
        ingredient.setMeal(meal);
        meal.setIngredients(Arrays.asList(ingredient));
        mealService.addMeal(meal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals(){
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/winter-meals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeals());
    }

}

