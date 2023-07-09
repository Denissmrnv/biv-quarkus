package edu.my.mapper;

import edu.my.dto.CharacteristicDTO;
import edu.my.entity.Characteristic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CharacteristicMapper {
    CharacteristicMapper INSTANCE = Mappers.getMapper(CharacteristicMapper.class);
    CharacteristicDTO toDTO(Characteristic category);
    Characteristic toEntity(CharacteristicDTO categoryDTO);
    List<CharacteristicDTO> toDTO(List<Characteristic> categoryList);
}
