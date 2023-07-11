package edu.my.service.impl;

import edu.my.dto.CategoryDTO;
import edu.my.dto.ProductDTO;
import edu.my.mapper.CategoryMapper;
import edu.my.mapper.ProductMapper;
import edu.my.repository.ProductRepository;
import edu.my.entity.Product;
import edu.my.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        return ProductMapper.INSTANCE.toDTO(productRepository.findAll().list());
    }

    @Override
    public ProductDTO getProduct(long id) {
        return ProductMapper.INSTANCE.toDTO(productRepository.findById(id));
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductDTO productDTO) {
        Product productSearch = productRepository.findById(id);
        productSearch.setCategory(productDTO.getCategory());
        productSearch.setDescription(productDTO.getDescription());
        productSearch.setPrice(productDTO.getPrice());
        productSearch.setCharacteristicSet(productDTO.getCharacteristicSet());
        productSearch.setName(productDTO.getName());
    }

    @Override
    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        productRepository.persist(ProductMapper.INSTANCE.toEntity(productDTO));
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

            productRepository.persist(ProductMapper.INSTANCE.toEntity(product));
        }
    }
}
