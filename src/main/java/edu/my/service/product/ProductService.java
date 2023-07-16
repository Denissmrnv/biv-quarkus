package edu.my.service.product;

import edu.my.dto.characteristic.CharacteristicDTO;
import edu.my.dto.product.ProductDTO;
import edu.my.entity.Characteristic;
import edu.my.mapper.ProductMapper;
import edu.my.repository.CharacteristicRepository;
import edu.my.repository.ProductRepository;
import edu.my.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;
    @Inject
    ProductMapper productMapper;
    @Inject
    CharacteristicRepository characteristicRepository;

    public List<ProductDTO> getAllProducts() {
        return productMapper.toDTO(productRepository.findAll().list());
    }

    public ProductDTO getProduct(long id) {
        return productMapper.toDTO(productRepository.findById(id));
    }

    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

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

    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Set<Characteristic> characteristicSet = product.getCharacteristicSet();
        for (Characteristic characteristic : characteristicSet) {
            characteristic.setProduct(product);
        }
        productRepository.persist(product);
    }

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
