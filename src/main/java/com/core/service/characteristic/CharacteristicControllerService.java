package com.core.service.characteristic;

import com.api.dto.characteristic.CharacteristicRequestDTO;
import com.api.dto.characteristic.CharacteristicResponseDTO;

import java.util.Set;

public interface CharacteristicControllerService {
    Set<CharacteristicResponseDTO> getAllCharacteristics();
    CharacteristicResponseDTO getCharacteristic(long id);
    void deleteCharacteristic(long id);
    void updateCharacteristic(long id, CharacteristicRequestDTO characteristicRequestDTO);
    void saveCharacteristic(CharacteristicRequestDTO characteristicRequestDTO);
}
