package edu.my.service.impl;

import edu.my.dto.ProductDTO;
import edu.my.entity.Characteristic;
import edu.my.entity.Product;
import edu.my.mapper.ProductMapper;
import edu.my.repository.CharacteristicRepository;
import edu.my.repository.ProductRepository;
import edu.my.service.ProductAndCategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ProductAndCategoryServiceImpl implements ProductAndCategoryService {
    @Inject
    ProductRepository productRepository;
    @Inject
    CharacteristicRepository characteristicRepository;
    @Inject
    ProductMapper productMapper;

    @Override
    @Transactional
    public void saveProductAndCharacteristic(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        productRepository.persist(product);
        Set<Characteristic> characteristicSet = productDTO.getCharacteristicSet();
        for (Characteristic characteristic: characteristicSet) {
            characteristic.setProduct(product);
            characteristicRepository.persist(characteristic);
        }
    }

    @Override
    @Transactional
    public void updateProductAndCharacteristic(long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id);

        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());

        Set<Characteristic> characteristicSet = productDTO.getCharacteristicSet();

        for (Characteristic characteristic: characteristicSet) {
            Characteristic characteristicInDB = characteristicRepository.findById(characteristic.getId());
            characteristicInDB.setName(characteristic.getName());
            characteristicInDB.setMeaning(characteristic.getMeaning());
            characteristicInDB.setProduct(product);
        }
    }
}
