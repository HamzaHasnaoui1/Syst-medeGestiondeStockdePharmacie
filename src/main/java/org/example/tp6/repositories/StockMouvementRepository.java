package org.example.tp6.repositories;

import org.example.tp6.entities.StockMouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockMouvement, Integer> {
}
