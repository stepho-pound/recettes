package com.sbe.lesrecettesdemaman.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ingredient")
public class Ingredient implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ingredient_id",nullable = false, updatable = false)
    private Long id;

    @Column(name="nom", nullable = false, updatable = true)
    private String nom;

    @Column(name="image", nullable = true, updatable = true)
    private String image;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    @Column(name="recettes", nullable = true, updatable = true)
    private List<Recette> recettes;

}
