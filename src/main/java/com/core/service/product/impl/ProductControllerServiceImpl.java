package com.core.service.product.impl;

import com.core.service.characteristic.CharacteristicService;
import com.core.service.product.ProductControllerService;
import com.core.service.product.ProductService;
import com.api.dto.product.ProductRequestDTO;
import com.api.dto.product.ProductResponseDTO;
import com.core.mapper.ProductMapper;
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
