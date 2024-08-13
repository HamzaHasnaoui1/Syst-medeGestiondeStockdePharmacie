package org.example.tp6.repositories;

import org.example.tp6.entities.ReceptionStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionStockRepository extends JpaRepository<ReceptionStock, Integer> {
}
