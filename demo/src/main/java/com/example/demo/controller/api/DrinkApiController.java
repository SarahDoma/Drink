package com.example.demo.controller.api;

import com.example.demo.domain.Drink;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DrinkApiController {

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkService drinkService;

    @RequestMapping("/drink")
    @GetMapping("/drink")
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok().body(drinkService.getAllDrink());
    }

    @RequestMapping("/drink/id")
    @GetMapping
    public ResponseEntity<Drink> getDrinkById(@PathVariable long id) {
        return ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }

    @PostMapping("/drink")
    @GetMapping
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
        return ResponseEntity.ok().body(drinkService.saveDrink(drink));
    }

    @PutMapping("/drink/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable long id, @RequestBody Drink drink) {
        return ResponseEntity.ok().body(drinkService.updateDrinkById(drink));
    }

    @DeleteMapping("/drink/{id}")
    public HttpStatus deleteDrink(@PathVariable long id) {
        drinkService.deleteDrinkById(id);
        return HttpStatus.OK;
    }
}

