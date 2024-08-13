package org.example.tp6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class StockReception {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Medicament medicament;
    private int quantiteRecue;
    private LocalDate dateRecepetion;
}
