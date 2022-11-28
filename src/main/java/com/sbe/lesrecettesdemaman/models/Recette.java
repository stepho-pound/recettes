package com.sbe.lesrecettesdemaman.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "recette")
public class Recette implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recette_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nom", nullable = false, updatable = true)
    private String nom;

    @Column(name="temps_preparation", nullable = true, updatable = true)
    private Integer tempsPreparation;

    @Column(name="image", nullable = true, updatable = true)
    private String image;

    //@ManyToMany(mappedBy = "recette")
    @ManyToMany
    @Column(name="ingredients", nullable = true, updatable = true)
    @JoinTable(
            name="recette_ingredients",
            joinColumns = @JoinColumn(name="recette_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredients;

    @Column(name="nombre_personne", nullable = true, updatable = true)
    private Integer nbrPerson;

    @Column(name="temps_cuisson", nullable = true, updatable = true)
    private Integer tempsCuisson;

    @Column(name="recette_texte", nullable = true, updatable = true)
    private String recetteTexte;

    @Column(name="reference", nullable = true, updatable = true)
    private String reference;

}
