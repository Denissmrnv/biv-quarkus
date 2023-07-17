package edu.my.service.characteristic;

import edu.my.dto.characteristic.CharacteristicDTO;
import java.util.List;

public interface CharacteristicControllerService {
    List<CharacteristicDTO> getAllCharacteristics();
    CharacteristicDTO getCharacteristic(long id);
    void deleteCharacteristic(long id);
    void updateCharacteristic(long id, CharacteristicDTO characteristicDTO);
    void saveCharacteristic(CharacteristicDTO characteristicDTO);
}
