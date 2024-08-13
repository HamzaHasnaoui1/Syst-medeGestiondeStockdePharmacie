package org.example.tp6.repositories;

import org.example.tp6.entities.StockReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockReceptionRepository extends JpaRepository<StockReception, Long> {
}
