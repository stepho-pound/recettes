package com.sbe.lesrecettesdemaman.services;

import com.sbe.lesrecettesdemaman.models.Ingredient;
import com.sbe.lesrecettesdemaman.models.Recette;
import com.sbe.lesrecettesdemaman.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService
{
    @Autowired
    private RecetteRepository recetteRepository;

    public Recette addRecette(Recette recette){
        return recetteRepository.save(recette);
    }

    public Recette getRecetteById(Long id){
        return recetteRepository.getById(id);
    }

    public List<Recette> getAllRecette(){
        return recetteRepository.findAll();
    }

    public Recette updateRecette(Recette recette){
        return recetteRepository.saveAndFlush(recette);
    }

    public String deleteRecette(Long id){
        recetteRepository.deleteById(id);
        return "Recette " + id + " supprimée";
    }

    public Recette addIngredientToRecette(Recette recette, Ingredient ingredient){
        List<Ingredient> updatedIngredientList = recette.getIngredients();

        updatedIngredientList.add(ingredient);

        recette.setIngredients(updatedIngredientList);
        return recette;
    }


    public Recette addIngredientsToRecette(Recette recette, List<Ingredient> ingredients){
        List<Ingredient> updatedIngredientList = recette.getIngredients();

        for(Ingredient ingredient : ingredients)
            updatedIngredientList.add(ingredient);

        recette.setIngredients(updatedIngredientList);
        return recette;
    }
}
