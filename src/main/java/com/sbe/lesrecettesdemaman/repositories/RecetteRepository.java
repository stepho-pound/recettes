package com.sbe.lesrecettesdemaman.repositories;

import com.sbe.lesrecettesdemaman.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecetteRepository extends JpaRepository<Recette, Long>
{
}
