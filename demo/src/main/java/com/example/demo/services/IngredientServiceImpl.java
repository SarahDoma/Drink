package com.example.demo.services;

import com.example.demo.domain.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService{

    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);

        Ingredient emptyIngredient = null;
        if (ingredient.isPresent()) {
            emptyIngredient = ingredient.get();
            return emptyIngredient;
        }else {
            throw new RuntimeException("Ingredient not found");
        }
    }

    @Override
    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        Optional<Ingredient> optional = ingredientRepository.findById(ingredient.getId());

        if (optional.isPresent()) {
        Ingredient updateIngredient = new Ingredient();
        updateIngredient.setIngredient(updateIngredient.getIngredient());
        updateIngredient.setId(updateIngredient.getId());
        updateIngredient.setName(updateIngredient.getName());

        ingredientRepository.save(updateIngredient);
        } else {
            throw new RuntimeException("Ingredient does not exist");
        }
        return ingredient;
    }

    @Override
    public void deleteIngredient(long id) {
    ingredientRepository.deleteById(id);
    }
}
