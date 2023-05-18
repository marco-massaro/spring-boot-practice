package com.example.springboot.Controller_path_variables_Request_params_returning_objects;

import com.example.springboot.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Exercise1 {
    private List<Meal> marcoMealObjects = Arrays.asList(
            new Meal("Chicken Tikka Masala", "Chicken tikka masala is a dish very yummy", 10.99),
            new Meal("Chicken Parm", "Very italian yummy", 15),
            new Meal("Chicken fried Steak", "Very american yum", 10.99),
            new Meal("Chicken and dumplings", "Presumably chinese yum", 9.99),
            new Meal("Chicken Pot Pie", "Cartman lovees this", 12.99),
            new Meal("Chicken cordon bleu", "French yum", 6.99),
            new Meal("Chicken noodle soup", "English yum", 6.99)
    );

    private List<Meal> marcoSoups = Arrays.asList(
            new Meal("Chicken noodle soup", "good noods", 6.99),
            new Meal("Tomato soup", "it's aight", 5.99),
            new Meal("Clam chowder", "vile", 4.99),
            new Meal("French onion soup", "sounds good", 3.99),
            new Meal("Minestrone soup", "Mamma mia", 2.99),
            new Meal("Chicken tortilla soup", "muy bien", 1.99),
            new Meal("bone broth soup", "crazy boujie", 8.99)
    );

    @GetMapping("/meals")
    public ResponseEntity<?> mealObjects(){
        return ResponseEntity.ok(marcoMealObjects);
    }
}
