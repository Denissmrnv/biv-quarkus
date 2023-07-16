package edu.my.service.characteristic.impl;

import edu.my.dto.characteristic.CharacteristicDTO;
import edu.my.service.characteristic.CharacteristicControllerService;
import edu.my.service.characteristic.CharacteristicService;
import jakarta.inject.Inject;

import java.util.List;

public class CharacteristicControllerServiceImpl implements CharacteristicControllerService {
    @Inject
    CharacteristicService characteristicService;

    @Override
    public List<CharacteristicDTO> getAllCharacteristics() {
        return characteristicService.getAllCharacteristics();
    }

    @Override
    public CharacteristicDTO getCharacteristic(long id) {
        return characteristicService.getCharacteristic(id);
    }

    @Override
    public void deleteCharacteristic(long id) {
        characteristicService.deleteCharacteristic(id);
    }

    @Override
    public void updateCharacteristic(long id, CharacteristicDTO characteristicDTO) {
        characteristicService.updateCharacteristic(id, characteristicDTO);
    }

    @Override
    public void saveCharacteristic(CharacteristicDTO characteristicDTO) {
        characteristicService.saveCharacteristic(characteristicDTO);
    }
}
