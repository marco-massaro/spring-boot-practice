package com.example.springboot.DevelhopeExercises;

import com.example.springboot.entity.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Exercise3_1 {
    private List<Meal> meals = new ArrayList<>();

    @GetMapping("/getMeal")
    public ResponseEntity<?> getMeals() {
        return ResponseEntity.ok(meals);
    }

    @PutMapping("/meal")
    public ResponseEntity<?> putMeals(@RequestBody Meal meal){
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added");
    }

    @PostMapping("/meal/{name}")
    public ResponseEntity<?> updateMealName(@RequestBody Meal meal,
                                            @PathVariable("name") String name){
        for (Meal m : meals){
            if(m.getName().equals(name)){
                m.setName(meal.getName());
                m.setDescription(meal.getDescription());
                m.setPrice(meal.getPrice());
                return ResponseEntity.ok("Marco updated successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meal doesn't exist lol");
    }

    @DeleteMapping("meal/{name}")
    public ResponseEntity<?> deleteMealsBasedOnName(@PathVariable("name") String name){
                this.meals.removeIf(meal -> meal.getName().equalsIgnoreCase(name));
                return ResponseEntity.ok("Deleted");
    }
    @DeleteMapping("meal/price/{price}")
    public ResponseEntity<?> deletePriceyMeals(@PathVariable("price") Double price){
                this.meals.removeIf(meal -> meal.getPrice() > (price));
                return ResponseEntity.ok("pricey meal deleted");
    }

    @PutMapping("meal/{name}/price")
    public ResponseEntity<?> updatePriceByName(@PathVariable("name") String name, @RequestBody Meal price){
        for (Meal m : meals){
            if(m.getName().equals(name)){
                m.setPrice(price.getPrice());
                return ResponseEntity.ok("Marco updated price successfully");
            }
        }
        return ResponseEntity.badRequest().build();
    }

}
