package org.example.tp6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @NoArgsConstructor @AllArgsConstructor
@Data @Builder
public class Medicament {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String nom;
   private double prix;
   private String dosage;
   private int quantiteStock;
   private int seuilMinimum;


}
