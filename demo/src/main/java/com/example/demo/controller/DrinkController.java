package com.example.demo.controller;

import com.example.demo.domain.Drink;
import com.example.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("drinks", drinkService.getAllDrink());
//        model.addAttribute("name", "daniel");
        return "index";
    }

    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model) {
        Drink drink = new Drink();
        model.addAttribute("drink", drink);
        return "new_drink";
    }

    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink) {
        drinkService.saveDrink(drink);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model){

        Drink drink = drinkService.getDrinkById(id);
        model.addAttribute("drink", drink);
        return "update_drink";
    }

    @PostMapping("/updateDrink")
    public String updateDrink(@ModelAttribute("drink") Drink drink, Model model){
        try {
            drinkService.saveDrink(drink);
            model.addAttribute("message", "Drink updated successfully");
        } catch (Exception e){
            model.addAttribute("message", "Error updating drink: " + e.getMessage());
            model.addAttribute("color", "danger");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteDrink/{id}")
    public String deleteDrink(@PathVariable long id){

        this.drinkService.deleteDrinkById(id);
        return "redirect:/";
    }
}
