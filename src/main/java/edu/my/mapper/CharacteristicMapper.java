package edu.my.mapper;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;
import edu.my.entity.Characteristic;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CharacteristicMapper {
    @Named("characteristicResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "meaning", source = "meaning")
    CharacteristicResponseDTO toResponseDTO(Characteristic characteristic);

    @InheritConfiguration
    @Named("characteristicSetResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    default Set<CharacteristicResponseDTO> toResponseDTO(Set<Characteristic> characteristicSet) {

        Set<CharacteristicResponseDTO> resultSet = new LinkedHashSet<>();

        for (Characteristic characteristic: characteristicSet) {

            CharacteristicResponseDTO characteristicResponseDTO = new CharacteristicResponseDTO();

            characteristicResponseDTO.setId(characteristic.getId());
            characteristicResponseDTO.setName(characteristic.getName());
            characteristicResponseDTO.setMeaning(characteristic.getMeaning());

            resultSet.add(characteristicResponseDTO);
        }
        return resultSet;
    }

    @Named("characteristicRequestDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "meaning", source = "meaning")
    Characteristic toEntity(CharacteristicRequestDTO characteristicRequestDTO);

    @InheritConfiguration
    @Named("characteristicSetRequestDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    default Set<Characteristic> toEntity(Set<CharacteristicRequestDTO> characteristicRequestDTOSet) {

        Set<Characteristic> resultSet = new LinkedHashSet<>();

        for (CharacteristicRequestDTO characteristicRequestDTO: characteristicRequestDTOSet) {

            Characteristic characteristic = new Characteristic();

            characteristic.setName(characteristicRequestDTO.getName());
            characteristic.setMeaning(characteristicRequestDTO.getMeaning());

            resultSet.add(characteristic);
        }
        return resultSet;
    }
}
