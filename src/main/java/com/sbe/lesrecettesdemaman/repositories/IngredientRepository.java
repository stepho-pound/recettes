package com.sbe.lesrecettesdemaman.repositories;

import com.sbe.lesrecettesdemaman.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository extends JpaRepository<Ingredient, Long>
{
}
