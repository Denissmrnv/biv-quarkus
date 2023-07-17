package edu.my.service.characteristic;

import edu.my.repository.CharacteristicRepository;
import edu.my.entity.Characteristic;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CharacteristicService {
    @Inject
    CharacteristicRepository characteristicRepository;

    public List<Characteristic> getAllCharacteristics() {
        return characteristicRepository.findAll().list();
    }

    public Characteristic getCharacteristic(long id) {
        return characteristicRepository.findById(id);
    }
    
    @Transactional
    public void deleteCharacteristic(long id) {
        characteristicRepository.deleteById(id);
    }

    @Transactional
    public void updateCharacteristic(long id, Characteristic characteristic) {
        Characteristic  characteristicSearch = characteristicRepository.findById(id);
        characteristicSearch.setName(characteristic.getName());
        characteristicSearch.setMeaning(characteristic.getMeaning());
        characteristicSearch.setProduct(characteristic.getProduct());
    }

    @Transactional
    public void saveCharacteristic(Characteristic characteristic) {
        characteristicRepository.persist(characteristic);
    }
}
