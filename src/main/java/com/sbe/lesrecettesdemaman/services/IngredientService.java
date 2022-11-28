package com.sbe.lesrecettesdemaman.services;

import com.sbe.lesrecettesdemaman.models.Ingredient;
import com.sbe.lesrecettesdemaman.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService
{

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id){
        return ingredientRepository.getById(id);
    }

    public List<Ingredient> getAllIngredient(){
        return ingredientRepository.findAll();
    }

    public Ingredient updateIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public String deleteIngredient(Long id){
        ingredientRepository.deleteById(id);
        return "Recette " + id + " supprimée";
    }
}
