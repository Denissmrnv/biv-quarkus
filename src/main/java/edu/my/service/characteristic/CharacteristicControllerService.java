package edu.my.service.characteristic;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;

import java.util.List;
import java.util.Set;

public interface CharacteristicControllerService {
    Set<CharacteristicResponseDTO> getAllCharacteristics();
    CharacteristicResponseDTO getCharacteristic(long id);
    void deleteCharacteristic(long id);
    void updateCharacteristic(long id, CharacteristicRequestDTO characteristicRequestDTO);
    void saveCharacteristic(CharacteristicRequestDTO characteristicRequestDTO);
}
