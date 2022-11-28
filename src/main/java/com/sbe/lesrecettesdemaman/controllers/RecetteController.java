package com.sbe.lesrecettesdemaman.controllers;

import com.sbe.lesrecettesdemaman.models.Recette;
import com.sbe.lesrecettesdemaman.services.IngredientService;
import com.sbe.lesrecettesdemaman.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recette")
public class RecetteController
{
    @Autowired
    private RecetteService recetteService;
    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recette> getAllRecette () {
        List<Recette> recettes = recetteService.getAllRecette();
        return recettes;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recette getRecetteById (@PathVariable("id") Long id) {
        Recette recette = recetteService.getRecetteById(id);
        return recette;
    }

    @RequestMapping(value = "/addRecette", method = RequestMethod.POST, consumes = "*/*")
    public Recette addRecette (@RequestBody Recette recette) {
        Recette newRecette = recetteService.addRecette(recette);
        return newRecette;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Recette updateRecette (@RequestBody Recette recette) {
        Recette updateRecette = recetteService.updateRecette(recette);
        return updateRecette;
    }

    @RequestMapping(value = "/addIngredients/{id}", method = RequestMethod.PATCH)
    public Recette addIngredientToRecette (@RequestBody Recette recette, @PathVariable("id") Long id) {

        Recette updateRecette = recetteService.addIngredientToRecette(recette, ingredientService.getIngredientById(id));
        updateRecette = recetteService.updateRecette(updateRecette);

        return updateRecette;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecette (@PathVariable("id") Long id) {
        recetteService.deleteRecette(id);
    }
}
