package org.example.tp6.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentDto {
    private String nom;
    private double prix;
    private String dosage;
    private int quantiteStock;
    private int seuilMinimum;
}
