package edu.my.service.product.impl;

import edu.my.dto.product.ProductRequestDTO;
import edu.my.dto.product.ProductResponseDTO;
import edu.my.mapper.ProductMapper;
import edu.my.service.characteristic.CharacteristicService;
import edu.my.service.product.ProductControllerService;
import edu.my.service.product.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductControllerServiceImpl implements ProductControllerService {
    @Inject
    ProductService productService;
    @Inject
    ProductMapper productMapper;

    @Inject
    CharacteristicService characteristicService;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productMapper.toResponseDTO(productService.getAllProducts());
    }

    @Override
    public ProductResponseDTO getProduct(long id) {
        return productMapper.toResponseDTO(productService.getProduct(id));
    }

    @Override
    public void deleteProduct(long id) {
        productService.deleteProduct(id);
    }

    @Override
    public void updateProduct(long id, ProductRequestDTO productRequestDTO) {
        productService.updateProduct(id, productMapper.toEntity(productRequestDTO));
    }

    @Override
    public void saveProduct(ProductRequestDTO productRequestDTO) {
        productService.saveProduct(productMapper.toEntity(productRequestDTO));
    }

    @Override
    public void saveOneHundredProduct(ProductRequestDTO productRequestDTO) {
        productService.saveOneHundredProduct(productMapper.toEntity(productRequestDTO));
    }
}
