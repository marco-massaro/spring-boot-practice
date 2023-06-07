package com.example.springboot.service;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.entity.Meal;
import com.example.springboot.dao.MealDAO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDAO mealDao;
    private Double MIN_WINTER_TEMP = 10.0;
    private Double MIN_SUMMER_TEMP = 20.0;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealService(MealDAO mealDao, RestaurantConfig restaurantConfig) {
        this.mealDao = mealDao;
        this.restaurantConfig = restaurantConfig;
    }

    public void addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Meall cannot be null!");
        if (meal.getName() == null || meal.getName().isEmpty())
            throw new IllegalArgumentException("Meal name cnanot be null or empty!");
        if (meal.getDescription() == null || meal.getDescription().isEmpty())
            throw new IllegalArgumentException("Meal description cannot be null or empty");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Price cannot be less than or equal to 0!");
        if (meal.getPrice() > 100) throw new IllegalArgumentException("Price cannot be more than 100!!");
        mealDao.save(meal);
    }

    public List<Meal> getMeals(){
        return mealDao.findAll();
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }

    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }

    public List<Meal> getSummerMeals(){
        Double currentTempInCelsius = getCurrentTempInCelsius();
        if (currentTempInCelsius < MIN_SUMMER_TEMP) return new ArrayList<>();
        return mealDao.findByIsSummerMeal(true);
    }
    public List<Meal> getWinterMeals(){
        Double currentTempInCelsius = getCurrentTempInCelsius();
        if (currentTempInCelsius < MIN_WINTER_TEMP) return new ArrayList<>();
        return mealDao.findByIsWinterMeal(true);
    }

    private Double getCurrentTempInCelsius() {
        try {
            JSONObject response =
                    Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=41.46&longitude=15.55&current_weather=true")
                    .asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
