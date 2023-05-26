package com.example.springboot.controller;

import com.example.springboot.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
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
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<?> deleteMeals(@PathVariable String mealName) {
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("meal deleted");
    }

}

