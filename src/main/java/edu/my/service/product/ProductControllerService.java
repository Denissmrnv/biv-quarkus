package edu.my.service.product;

import edu.my.dto.product.ProductRequestDTO;
import edu.my.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductControllerService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(long id);
    void deleteProduct(long id);
    void updateProduct(long id, ProductRequestDTO productRequestDTO);
    void saveProduct(ProductRequestDTO productRequestDTO);
    void saveOneHundredProduct(ProductRequestDTO productRequestDTO);
}
