package edu.my.service.impl;

import edu.my.dto.CategoryDTO;
import edu.my.dto.CharacteristicDTO;
import edu.my.dto.ProductDTO;
import edu.my.entity.Characteristic;
import edu.my.mapper.CategoryMapper;
import edu.my.mapper.CharacteristicMapper;
import edu.my.mapper.ProductMapper;
import edu.my.repository.CharacteristicRepository;
import edu.my.repository.ProductRepository;
import edu.my.entity.Product;
import edu.my.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;
    @Inject
    ProductMapper productMapper;
    @Inject
    CharacteristicRepository characteristicRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productMapper.toDTO(productRepository.findAll().list());
    }

    @Override
    public ProductDTO getProduct(long id) {
        return productMapper.toDTO(productRepository.findById(id));
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id);

        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());

        Set<CharacteristicDTO> characteristicSetDTO = productDTO.getCharacteristicSet();

        for (CharacteristicDTO characteristicDTO: characteristicSetDTO) {
            Characteristic characteristic = characteristicRepository.findById(characteristicDTO.getId());
            characteristic.setName(characteristicDTO.getName());
            characteristic.setMeaning(characteristicDTO.getMeaning());
            characteristic.setProduct(product);
        }
    }

    @Override
    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Set<Characteristic> characteristicSet = product.getCharacteristicSet();
        for (Characteristic characteristic : characteristicSet) {
            characteristic.setProduct(product);
        }
        productRepository.persist(product);
    }

    @Override
    @Transactional
    public void saveOneHundredProduct(ProductDTO productDTO) {
        for (int i = 0; i < 100; i++) {
            ProductDTO product = new ProductDTO();

            product.setCategory(productDTO.getCategory());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setCharacteristicSet(productDTO.getCharacteristicSet());
            product.setName(productDTO.getName() + " " + i);

            productRepository.persist(productMapper.toEntity(product));
        }
    }
}
