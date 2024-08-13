package org.example.tp6.controllers;

import org.example.tp6.dtos.MedicamentDto;
import org.example.tp6.entities.Medicament;
import org.example.tp6.services.IGestionMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/medicament")
public class GestionStockController {
    @Autowired
    private IGestionMedicamentService gestionMedicamentService;

    @PostMapping("/add")
    public MedicamentDto addMedicament(@RequestBody MedicamentDto  medicamentDto) {
        return gestionMedicamentService.addMedicament(medicamentDto);
    }

    @PutMapping("/update/{id}")
    public MedicamentDto updateMedicament(@PathVariable Long id ,@RequestBody MedicamentDto medicamentDto) {
        return gestionMedicamentService.updateMedicament(id ,medicamentDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicament(@PathVariable Long id) {
        gestionMedicamentService.deleteMedicament(id);
    }

    @GetMapping("/allMedi")
    public List<MedicamentDto> getAllMedi() {
        return gestionMedicamentService.getAllMedicament();
    }

    @GetMapping("/getById/{id}")
    public MedicamentDto getMedicamentById(@PathVariable Long id) {
        return gestionMedicamentService.getMedicamentById(id);
    }
}
