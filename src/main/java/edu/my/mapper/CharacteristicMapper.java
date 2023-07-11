package edu.my.mapper;

import edu.my.dto.CharacteristicDTO;
import edu.my.entity.Characteristic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);
    CharacteristicDTO toDTO(Characteristic category);
    List<CharacteristicDTO> toDTO(List<Characteristic> categoryList);
    Set<CharacteristicDTO> toDTO(Set<Characteristic> categoryList);

    Characteristic toEntity(CharacteristicDTO categoryDTO);
}
