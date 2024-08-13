package org.example.tp6.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp6.entities.Medicament;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockReceptionDto {
    private long medicamentId;
    private int quantiteRecue;
    private LocalDateTime dateRecepetion;
}
