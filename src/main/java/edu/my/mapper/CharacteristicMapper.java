package edu.my.mapper;

import edu.my.dto.CharacteristicDTO;
import edu.my.entity.Characteristic;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CharacteristicMapper {
    CharacteristicDTO toDTO(Characteristic characteristic);
    List<CharacteristicDTO> toDTO(List<Characteristic> characteristicList);
    Set<CharacteristicDTO> toDTO(Set<Characteristic> characteristicSet);
    Characteristic toEntity(CharacteristicDTO characteristicDTO);
    List<Characteristic> toEntity(List<CharacteristicDTO> characteristicDTOList);
    Set<Characteristic> toEntity(Set<CharacteristicDTO> characteristicDTOSet);
}
