package com.core.service.product;

import com.api.dto.product.ProductRequestDTO;
import com.api.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductControllerService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(long id);
    void deleteProduct(long id);
    void updateProduct(long id, ProductRequestDTO productRequestDTO);
    void saveProduct(ProductRequestDTO productRequestDTO);
    void saveOneHundredProduct(ProductRequestDTO productRequestDTO);
}
