package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private List<Meal> meals = new ArrayList<>();

    @GetMapping("/get/meals")
    public ResponseEntity<?> getMeals() {
        return ResponseEntity.ok(meals);
    }

    @PutMapping("/put/meals")
    public ResponseEntity<?> putMeals(@RequestBody Meal meal){
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added");
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<?> deleteMeals(@PathVariable String mealName){
        this.meals.removeIf(meal -> meal.getName().equals(mealName));
        return ResponseEntity.ok("meal deleted");
    }

    @PostMapping("/post/replace-meal")
    public ResponseEntity<?> postMeal(@RequestBody Meal meal){
        this.meals.removeIf(m -> m.getName().equals(meal.getName()));
        this.meals.add(meal);
        return ResponseEntity.ok("Meal Updated");
    }


}

