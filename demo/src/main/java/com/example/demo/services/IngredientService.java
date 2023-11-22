package com.example.demo.services;

import com.example.demo.domain.Drink;
import com.example.demo.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient getIngredientById(long id);
    List<Ingredient> getAllIngredient();
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient(long id);
}
