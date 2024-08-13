package org.example.tp6.mappers;

import lombok.Builder;
import lombok.Data;
import org.example.tp6.dtos.StockMouvementDto;
import org.example.tp6.entities.Medicament;
import org.example.tp6.entities.StockMouvement;
import org.example.tp6.enums.Type;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface StockMouvementMapper {
    StockMouvementMapper stockMovMapper = Mappers.getMapper(StockMouvementMapper.class);

    StockMouvementDto toStockMouvementDto(StockMouvement stockMouvement);
    StockMouvement toStockMouvement(StockMouvementDto stockMouvementDto);


}
