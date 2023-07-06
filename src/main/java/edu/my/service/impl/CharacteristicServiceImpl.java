package edu.my.service.impl;

import edu.my.dao.CharacteristicRepository;
import edu.my.entity.Characteristic;
import edu.my.service.CharacteristicService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CharacteristicServiceImpl implements CharacteristicService {
    @Inject
    CharacteristicRepository characteristicRepository;

    @Override
    public List<Characteristic> getAllCharacteristics() {
        return characteristicRepository.findAll().list();
    }

    @Override
    public Characteristic getCharacteristic(long id) {
        return characteristicRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteCharacteristic(long id) {
        characteristicRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCharacteristic(long id, Characteristic characteristic) {
        Characteristic  characteristicSearch = characteristicRepository.findById(id);
        characteristicSearch.setName(characteristic.getName());
        characteristicSearch.setBeaning(characteristic.getBeaning());
        characteristicSearch.setProduct(characteristic.getProduct());
        characteristicRepository.persist(characteristicSearch);
    }

    @Override
    @Transactional
    public void saveCharacteristic(Characteristic characteristic) {
        characteristicRepository.persist(characteristic);
    }
}
