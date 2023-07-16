package edu.my.service;

import edu.my.dto.characteristic.CharacteristicDTO;
import java.util.List;

public interface CharacteristicService {
    public List<CharacteristicDTO> getAllCharacteristics();
    public CharacteristicDTO getCharacteristic(long id);
    public void deleteCharacteristic(long id);
    public void updateCharacteristic(long id, CharacteristicDTO characteristicDTO);
    public void saveCharacteristic(CharacteristicDTO characteristicDTO);
}
