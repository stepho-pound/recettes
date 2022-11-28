package com.sbe.lesrecettesdemaman.controllers;

import com.sbe.lesrecettesdemaman.models.Ingredient;
import com.sbe.lesrecettesdemaman.services.IngredientService;
import com.sbe.lesrecettesdemaman.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController
{
    @Autowired
    private RecetteService recetteService;
    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ingredient> getAllIngredient () {
        List<Ingredient> ingredients = ingredientService.getAllIngredient();
        return ingredients;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ingredient getIngredientById (@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        return ingredient;
    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST, consumes = "*/*")
    public Ingredient addIngredient (@RequestBody Ingredient ingredient) {
        Ingredient newIngredient = ingredientService.addIngredient(ingredient);
        return newIngredient;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Ingredient updateIngredient (@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(ingredient);
        return updateIngredient;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteIngredient (@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
    }
}
