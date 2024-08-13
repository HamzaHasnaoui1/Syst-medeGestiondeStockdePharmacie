package org.example.tp6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
public class StockReception {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medicament medicament;
    private int quantiteRecue;
    private LocalDateTime dateRecepetion;
}
