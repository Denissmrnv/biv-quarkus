package edu.my.service.product;

import edu.my.dto.product.ProductDTO;

import java.util.List;

public interface ProductControllerService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProduct(long id);
    public void deleteProduct(long id);
    public void updateProduct(long id, ProductDTO productDTO);
    public void saveProduct(ProductDTO productDTO);
    public void saveOneHundredProduct(ProductDTO productDTO);
}
