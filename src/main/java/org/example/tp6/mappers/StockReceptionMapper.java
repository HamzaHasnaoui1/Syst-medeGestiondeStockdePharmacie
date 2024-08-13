package org.example.tp6.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp6.entities.Medicament;

import java.time.LocalDate;

@Builder
@Data
public class StockReceptionDto {
    private Medicament medicament;
    private int quantiteRecue;
    private LocalDate dateRecepetion;
}
