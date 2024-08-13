package org.example.tp6.controllers;

import org.example.tp6.dtos.StockMouvementDto;
import org.example.tp6.dtos.StockReceptionDto;
import org.example.tp6.services.IGestionMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
public class GestionStockController {

    @Autowired
    private IGestionMedicamentService gestionMedicamentService;

    @PostMapping("/save")
    public StockReceptionDto addStock(@RequestBody StockReceptionDto stockReceptionDtoDto) {
        return gestionMedicamentService.saveStockReception(stockReceptionDtoDto);
    }

    @GetMapping("/historique")
    public List<StockReceptionDto> historique() {
        return gestionMedicamentService.getAllStockReception();
    }


    @PostMapping("/gestionStock")
    public ResponseEntity<StockMouvementDto> gestionStock(@RequestBody StockMouvementDto stockMouvementDto) {
         gestionMedicamentService.gestionStock(stockMouvementDto);
        return new ResponseEntity<>(stockMouvementDto, HttpStatus.CREATED);
    }

}
