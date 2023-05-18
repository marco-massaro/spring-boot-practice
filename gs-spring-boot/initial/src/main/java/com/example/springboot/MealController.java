package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private List<Meal> chefsSpecials = Arrays.asList(
            new Meal("Chicken Tikka Masala", "Chicken tikka masala is a dish very yummy", 10.99),
            new Meal("Chicken Parm", "Very italian yummy", 15),
            new Meal("Chicken fried Steak", "Very american yum", 10.99),
            new Meal("Chicken and dumplings", "Presumably chinese yum", 9.99),
            new Meal("Chicken Pot Pie", "Cartman lovees this", 12.99),
            new Meal("Chicken cordon bleu", "French yum", 6.99),
            new Meal("Chicken noodle soup", "English yum", 6.99)
    );

    private List<Meal> soupOfTheDay = Arrays.asList(
            new Meal("Chicken noodle soup", "good noods", 6.99),
            new Meal("Tomato soup", "it's aight", 5.99),
            new Meal("Clam chowder", "vile", 4.99),
            new Meal("French onion soup", "sounds good", 3.99),
            new Meal("Minestrone soup", "Mamma mia", 2.99),
            new Meal("Chicken tortilla soup", "muy bien", 1.99),
            new Meal("bone broth soup", "crazy boujie", 8.99)
    );

    @GetMapping("/get/day-dependent-meal/")
    public ResponseEntity<?> getChefsSpecial(
            @RequestParam("isSoupOfTheDay") boolean isSoupOfTheDay,
//			@PathVariable("isSoupOfTheDay") boolean isSoupOfTheDay,
            @RequestParam("dayOfTheWeekIndex") int dayOfTheWeekIndex) {
//			@PathVariable("dayOfTheWeekIndex") int dayOfTheWeekIndex) {
        if (dayOfTheWeekIndex < 0 || dayOfTheWeekIndex > 6) {
            return ResponseEntity.badRequest().body("Invalid day of the week index. Must be between 0 and 6");
        }
        if (isSoupOfTheDay) {
            return ResponseEntity.ok(soupOfTheDay.get(dayOfTheWeekIndex));
        } else {
            return ResponseEntity.ok(chefsSpecials.get(dayOfTheWeekIndex));
        }


    }

}
