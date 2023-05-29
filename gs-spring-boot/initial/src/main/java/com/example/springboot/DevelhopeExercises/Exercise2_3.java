package com.example.springboot.DevelhopeExercises;

import com.example.springboot.entity.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Exercise2_3 {
    private List<Meal> marcoMealObjects = Arrays.asList(
            new Meal("Chicken Tikka Masala", "Chicken tikka masala is a dish very yummy", 10.99,true),
            new Meal("Chicken Parm", "Very italian yummy", 15,true),
            new Meal("Chicken fried Steak", "Very american yum", 10.99,true),
            new Meal("Chicken and dumplings", "Presumably chinese yum", 9.99,true),
            new Meal("Chicken Pot Pie", "Cartman lovees this", 12.99,true),
            new Meal("Chicken cordon bleu", "French yum", 6.99,true),
            new Meal("Chicken noodle soup", "English yum", 6.99,true)
    );
    @GetMapping("meal/description-match/{phrase}")
    public ResponseEntity<?> getDescriptionMatch(
            @PathVariable("phrase") String phrase){
        for (Meal meal : marcoMealObjects){
            if (meal.getDescription().toLowerCase().contains(phrase.toLowerCase())){
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
