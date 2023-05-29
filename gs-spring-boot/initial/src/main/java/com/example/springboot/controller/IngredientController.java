package com.example.springboot.controller;

import com.example.springboot.entity.Ingredient;
import com.example.springboot.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealservice;

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealservice) {
        this.ingredientService = ingredientService;
        this.mealservice = mealservice;
    }

    @PostMapping("/add-ingredient")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addingredient(ingredient);
        return ResponseEntity.ok().body("Ingredient added successfully");
    }

    @PutMapping("/update-ingredient/{id}")
    public ResponseEntity<String> updateIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        ingredientService.replaceItem(ingredient, id);
        return ResponseEntity.ok().body("Ingredient updated");
    }

    @DeleteMapping("/delete-ingredient")
    public ResponseEntity<String> deleteIngredient(@RequestParam long id) {
        ingredientService.removeByID(id);
        return ResponseEntity.ok().body("Ingredient deleted successfully");
    }

    @GetMapping("/get-ingredient")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam long id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        return ResponseEntity.ok().body(ingredient);
    }

}
