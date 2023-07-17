package edu.my.mapper;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;
import edu.my.entity.Characteristic;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CharacteristicMapper {
    @Named("characteristicResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "meaning", source = "meaning")
    @Mapping(target = "product", source = "product")
    CharacteristicResponseDTO toResponseDTO(Characteristic characteristic);

    default Set<CharacteristicResponseDTO> toResponseDTO(Set<Characteristic> characteristicSet) {
        Set<CharacteristicResponseDTO> result = new LinkedHashSet<>();
        for (Characteristic characteristic: characteristicSet) {
            result.add(toResponseDTO(characteristic));
        }
        return result;
    }

    default List<CharacteristicResponseDTO> toResponseDTO(List<Characteristic> characteristicList) {
        List<CharacteristicResponseDTO> result = new ArrayList<>();
        for (Characteristic characteristic: characteristicList) {
            result.add(toResponseDTO(characteristic));
        }
        return result;
    }

    @Named("characteristicResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "meaning", source = "meaning")
    @Mapping(target = "product", source = "product")
    Characteristic toEntity(CharacteristicRequestDTO characteristicRequestDTO);
}
