package edu.my.service.characteristic.impl;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;
import edu.my.mapper.CharacteristicMapper;
import edu.my.service.characteristic.CharacteristicControllerService;
import edu.my.service.characteristic.CharacteristicService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class CharacteristicControllerServiceImpl implements CharacteristicControllerService {
    @Inject
    CharacteristicService characteristicService;
    @Inject
    CharacteristicMapper characteristicMapper;

    @Override
    public Set<CharacteristicResponseDTO> getAllCharacteristics() {
        return characteristicMapper.toResponseDTO(characteristicService.getAllCharacteristics());
    }

    @Override
    public CharacteristicResponseDTO getCharacteristic(long id) {
        return characteristicMapper.toResponseDTO(characteristicService.getCharacteristic(id));
    }

    @Override
    public void deleteCharacteristic(long id) {
        characteristicService.deleteCharacteristic(id);
    }

    @Override
    public void updateCharacteristic(long id, CharacteristicRequestDTO characteristicRequestDTO) {
        characteristicService.updateCharacteristic(id, characteristicMapper.toEntity(characteristicRequestDTO));
    }

    @Override
    public void saveCharacteristic(CharacteristicRequestDTO characteristicRequestDTO) {
        characteristicService.saveCharacteristic(characteristicMapper.toEntity(characteristicRequestDTO));
    }
}
