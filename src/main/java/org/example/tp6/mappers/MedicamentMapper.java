package org.example.tp6.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MedicamentDto {
    private String nom;
    private double prix;
    private String dosage;
    private int quantiteStock;
}
