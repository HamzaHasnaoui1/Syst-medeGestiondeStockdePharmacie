package org.example.tp6.dtos;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.example.tp6.entities.Medicament;
import org.example.tp6.enums.Type;
import java.time.LocalDate;

@Builder
@Data
public class StockMouvementDto {
    private Type type;
    private Medicament medicament;
    private int quantite;
    private LocalDate date;
}
