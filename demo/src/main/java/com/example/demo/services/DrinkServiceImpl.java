package com.example.demo.services;

import com.example.demo.domain.Drink;
import com.example.demo.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService{

    @Autowired
    DrinkRepository drinkRepository;
    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);

        Drink emptyDrink = null;
        if (drink.isPresent()) {
            emptyDrink = drink.get();
            return emptyDrink;
        }else {
            throw new RuntimeException("Drink not found");
        }
    }

    @Override
    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink updateDrink(Drink drink) {
        Optional<Drink> optional = drinkRepository.findById(drink.getId());

        if (optional.isPresent()) {
        Drink updateDrink = new Drink();
        updateDrink.setCapacity(updateDrink.getCapacity());
        updateDrink.setColour(updateDrink.getColour());
        updateDrink.setCompany(updateDrink.getCompany());
        updateDrink.setName(updateDrink.getName());
        updateDrink.setType(updateDrink.getType());
        updateDrink.setId(updateDrink.getId());
        updateDrink.setPrice(updateDrink.getPrice());
        updateDrink.setIngredientList(drink.getIngredientList());

        drinkRepository.save(updateDrink);
        }else {
            throw new RuntimeException("Drink does not exist");
        }
        return drink;
    }

    @Override
    public void deleteDrink(long id) {
    drinkRepository.deleteById(id);
    }
}
