package com.example.springboot.dao;

import com.example.springboot.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient, Long> {
}
