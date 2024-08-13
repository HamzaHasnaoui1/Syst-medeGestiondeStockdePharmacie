package org.example.tp6.services;

import org.example.tp6.dtos.MedicamentDto;
import org.example.tp6.dtos.StockMouvementDto;
import org.example.tp6.dtos.StockReceptionDto;

import java.util.List;

public interface IGestionMedicamentService {


    MedicamentDto addMedicament(MedicamentDto medicamentDto);


    MedicamentDto updateMedicament(Long id, MedicamentDto medicamentDto);

    void deleteMedicament(long id);

    List<MedicamentDto> getAllMedicament();


    MedicamentDto getMedicamentById(Long id);

    StockReceptionDto saveStockReception(StockReceptionDto stockReceptionDto);

    List<StockReceptionDto> getAllStockReception();

    void gestionStock(StockMouvementDto stockMouvementDto);
}
