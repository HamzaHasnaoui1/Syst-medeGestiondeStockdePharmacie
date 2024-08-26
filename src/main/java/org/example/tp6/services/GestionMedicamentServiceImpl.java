package org.example.tp6.services;

import org.example.tp6.dtos.MedicamentDto;
import org.example.tp6.dtos.StockMouvementDto;
import org.example.tp6.dtos.StockReceptionDto;
import org.example.tp6.entities.Medicament;
import org.example.tp6.entities.StockMouvement;
import org.example.tp6.entities.StockReception;
import org.example.tp6.enums.Type;
import org.example.tp6.mappers.MedicamentMapper;
import org.example.tp6.mappers.StockMouvementMapper;
import org.example.tp6.mappers.StockReceptionMapper;
import org.example.tp6.repositories.MedicamentRepository;
import org.example.tp6.repositories.StockMouvementRepository;
import org.example.tp6.repositories.StockReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GestionMedicamentServiceImpl implements IGestionMedicamentService {
    private Type type;
    @Autowired
    private MedicamentRepository medicamentRepository;
    //    @Autowired
    private MedicamentMapper medicamentMapper;

    @Autowired
    private StockReceptionRepository stockReceptionRepository;
    @Autowired
    private StockReceptionMapper stockReceptionMapper;

    @Autowired
    private StockMouvementRepository stockMouvementRepository;
    //    @Autowired
    private StockMouvementMapper stockMouvementMapper;
    @Autowired
    private EmailService emailService;

    @Override
    public MedicamentDto addMedicament(MedicamentDto medicamentDto) {
        Medicament medicament = MedicamentMapper.medicamentInstance.fromDtoToMedicament(medicamentDto);
        Medicament savedMedicament = medicamentRepository.save(medicament);
        return MedicamentMapper.medicamentInstance.fromEntityToMedicamentDto(savedMedicament);
    }

    @Override
    public MedicamentDto updateMedicament(Long id, MedicamentDto medicamentDto) {
        Medicament oldMedicament = medicamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicament non trouve"));
        Medicament updatedMedicament = MedicamentMapper.medicamentInstance
                .updateMedicamentFromDtoToEntity(medicamentDto, oldMedicament);
        return MedicamentMapper.medicamentInstance.fromEntityToMedicamentDto(updatedMedicament);
    }

    @Override
    public void deleteMedicament(long id) {
        medicamentRepository.deleteById(id);
    }

    @Override
    public List<MedicamentDto> getAllMedicament() {
        return MedicamentMapper.medicamentInstance.fromEntityToMedicamentDtoList(medicamentRepository.findAll());
    }

    @Override
    public MedicamentDto getMedicamentById(Long id) {

        Medicament medicament = medicamentRepository.findById(id).orElse(null);
        return MedicamentMapper.medicamentInstance.fromEntityToMedicamentDto(medicament);
    }

    @Override
    public StockReceptionDto saveStockReception(StockReceptionDto stockReceptionDto) {
        Medicament medicament = medicamentRepository.findById(stockReceptionDto.getMedicamentId())
                .orElseThrow(() -> new RuntimeException("Medicament not found"));
        StockReception stockReception = stockReceptionMapper.fromDtoToStockReceptionEntity(stockReceptionDto);
        stockReception.setMedicament(medicament);
        StockReception savedStockReception = stockReceptionRepository.save(stockReception);
        return stockReceptionMapper.fromEntityToStockReceptionDto(savedStockReception);
    }


    @Override
    public List<StockReceptionDto> getAllStockReception() {
        return StockReceptionMapper.stockRecMapperInst.fromEntityToStockReceptionDtoList(stockReceptionRepository.findAll());
    }

    @Transactional
    @Override
    public void gestionStock(StockMouvementDto stockMouvementDto) {

        Medicament medicament = medicamentRepository.findById(stockMouvementDto.getMedicamentId())
                .orElseThrow(() -> new RuntimeException("Medicament non trouve"));

        if (stockMouvementDto.getType() == Type.reception) {
            medicament.setQuantiteStock(medicament.getQuantiteStock() + stockMouvementDto.getQuantite());
        } else if (stockMouvementDto.getType() == Type.vente) {
            if (medicament.getQuantiteStock() < stockMouvementDto.getQuantite()) {
                throw new RuntimeException("Stock insuffisant pour la vente");
            }
            medicament.setQuantiteStock(medicament.getQuantiteStock() - stockMouvementDto.getQuantite());
        } else {
            throw new IllegalArgumentException("Type de mouvement inconnu");
        }

        if (medicament.getQuantiteStock()< medicament.getSeuilMinimum()){
            alerte(medicament);
        }

        StockMouvement stockMouvement = StockMouvement.builder()
                .type(stockMouvementDto.getType())
                .medicament(medicament)
                .quantite(stockMouvementDto.getQuantite())
                .date(LocalDateTime.now())
                .build();

        stockMouvementRepository.save(stockMouvement);
        medicamentRepository.save(medicament);
    }

    private void alerte(Medicament medicament) {
        String subject = "Alerte de stock faible : " + medicament.getNom();
        String text = "Le stock du médicament " + medicament.getNom() +
                " est inférieur au seuil minimum de " + medicament.getSeuilMinimum() +
                " unités. Quantité actuelle : " + medicament.getQuantiteStock();

        emailService.sendEmail("lasoror798@hapied.com", subject, text);
    }
}
