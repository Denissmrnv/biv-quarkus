package com.core.service.characteristic.impl;

import com.core.service.characteristic.CharacteristicControllerService;
import com.core.service.characteristic.CharacteristicService;
import com.api.dto.characteristic.CharacteristicRequestDTO;
import com.api.dto.characteristic.CharacteristicResponseDTO;
import com.core.mapper.CharacteristicMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
