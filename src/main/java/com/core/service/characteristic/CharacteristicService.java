package com.core.service.characteristic;

import com.core.repository.CharacteristicRepository;
import com.core.entity.Characteristic;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class CharacteristicService {
    @Inject
    CharacteristicRepository characteristicRepository;

    public Set<Characteristic> getAllCharacteristics() {
        return new HashSet<>(characteristicRepository.findAll().list());
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
