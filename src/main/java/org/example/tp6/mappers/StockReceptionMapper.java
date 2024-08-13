package org.example.tp6.mappers;

import org.example.tp6.dtos.StockReceptionDto;
import org.example.tp6.entities.StockReception;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface StockReceptionMapper {
    StockReceptionMapper stockRecMapperInst = Mappers.getMapper(StockReceptionMapper.class);

    StockReceptionDto fromEntityToStockReceptionDto(StockReception stockReception);

    // @Mapping(target = "medicament", ignore = true)
    StockReception fromDtoToStockReceptionEntity(StockReceptionDto stockReceptionDto);

    List<StockReceptionDto> fromEntityToStockReceptionDtoList(List<StockReception> stockReceptionList);

}
