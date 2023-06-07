package com.example.springboot.dao;

import com.example.springboot.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MealDAO extends JpaRepository<Meal,Long> {

    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);

        // findBy <-- this specifies query type
            // Price <-- specifies the field to query
                // GreaterThan <-- specifies the query type
                    //And <-- can be used as AND condition
                        //Name <-- specifies the other field and must be also included in the parameter
    //Exrecise1:
    //Create a query method that finds all meals with a given desription
    List<Meal> findByDescription(String description);
    //Exrecise2:
    //Create a query method that finds all meals with a price less than a given value
    List<Meal> findByPriceLowerThan(double price);
    //Exrecise3:
    //Create a query method that finds all meals with a price between two values
    //Between keyword, 2 parameters
    List<Meal> findByPriceBetween(double minPrice, double maxPrice);
    //Exrecise4:
    //Create a query method that finds all meals with a given description and a price less than a given value
    List<Meal> findByDescriptionAndPriceLowerThan(String description, double price);

    List<Meal> findByIsSummerMeal(boolean isSummerMeal);
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);
}
