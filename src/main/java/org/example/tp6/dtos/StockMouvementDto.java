package org.example.tp6.dtos;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp6.entities.Medicament;
import org.example.tp6.enums.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMouvementDto {
    private Type type;
    private long medicamentId;
    private int quantite;
    private LocalDateTime date;
}
