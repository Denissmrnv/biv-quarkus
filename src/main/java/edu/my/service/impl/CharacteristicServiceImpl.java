package edu.my.service.impl;

import edu.my.dto.characteristic.CharacteristicDTO;
import edu.my.mapper.CharacteristicMapper;
import edu.my.repository.CharacteristicRepository;
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
    @Inject
    CharacteristicMapper characteristicMapper;

    @Override
    public List<CharacteristicDTO> getAllCharacteristics() {
        return characteristicMapper.toDTO(characteristicRepository.findAll().list());
    }

    @Override
    public CharacteristicDTO getCharacteristic(long id) {
        return characteristicMapper.toDTO(characteristicRepository.findById(id));
    }

    @Override
    @Transactional
    public void deleteCharacteristic(long id) {
        characteristicRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCharacteristic(long id, CharacteristicDTO characteristicDTO) {
        Characteristic  characteristicSearch = characteristicRepository.findById(id);
        characteristicSearch.setName(characteristicDTO.getName());
        characteristicSearch.setMeaning(characteristicDTO.getMeaning());
        characteristicSearch.setProduct(characteristicDTO.getProduct());
    }

    @Override
    @Transactional
    public void saveCharacteristic(CharacteristicDTO characteristicDTO) {
        characteristicRepository.persist(characteristicMapper.toEntity(characteristicDTO));
    }
}
