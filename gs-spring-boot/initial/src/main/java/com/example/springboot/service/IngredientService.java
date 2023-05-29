package com.example.springboot.service;

import com.example.springboot.dao.IngredientDAO;
import com.example.springboot.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientDAO ingredientDAO;

    @Autowired
    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public void addingredient(Ingredient dumpling) {
        ingredientDAO.save(dumpling);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredientDAO.delete(ingredient);
    }

    public void removeByID(Long id) {
        ingredientDAO.deleteById(id);
    }

    public void replaceItem(Ingredient ingredient, Long id) {
        removeByID(id);
        addingredient(ingredient);
    }

    public Ingredient getIngredient(long id) {
        return ingredientDAO.findById(id).orElse(null);
    }
}
