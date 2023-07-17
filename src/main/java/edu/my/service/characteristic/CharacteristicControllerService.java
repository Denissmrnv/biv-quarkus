package edu.my.service.characteristic;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;

import java.util.List;

public interface CharacteristicControllerService {
    List<CharacteristicResponseDTO> getAllCharacteristics();
    CharacteristicResponseDTO getCharacteristic(long id);
    void deleteCharacteristic(long id);
    void updateCharacteristic(long id, CharacteristicRequestDTO characteristicRequestDTO);
    void saveCharacteristic(CharacteristicRequestDTO characteristicRequestDTO);
}
