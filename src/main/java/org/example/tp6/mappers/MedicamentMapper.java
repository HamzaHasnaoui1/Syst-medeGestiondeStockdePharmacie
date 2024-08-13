package org.example.tp6.mappers;

import org.example.tp6.dtos.MedicamentDto;
import org.example.tp6.entities.Medicament;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicamentMapper {

    MedicamentMapper medicamentInstance = Mappers.getMapper(MedicamentMapper.class);

    MedicamentDto fromEntityToMedicamentDto(Medicament medicament);

    Medicament fromDtoToMedicament(MedicamentDto medicamentDto);

    Medicament updateMedicamentFromDtoToEntity(MedicamentDto medicamentDto, @MappingTarget Medicament medicament);

    List<MedicamentDto> fromEntityToMedicamentDtoList(List<Medicament> medicaments);
}
