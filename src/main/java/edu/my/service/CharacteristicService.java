package edu.my.service;

import edu.my.entity.Characteristic;
import java.util.List;

public interface CharacteristicService {
    public List<Characteristic> getAllCharacteristics();
    public Characteristic getCharacteristic(long id);
    public void deleteCharacteristic(long id);
    public void updateCharacteristic(long id, Characteristic characteristic);
    public void saveCharacteristic(Characteristic characteristic);
}
