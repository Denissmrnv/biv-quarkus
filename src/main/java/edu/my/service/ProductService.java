package edu.my.service;

import edu.my.dto.product.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProduct(long id);
    public void deleteProduct(long id);
    public void updateProduct(long id, ProductDTO productDTO);
    public void saveProduct(ProductDTO productDTO);
    public void saveOneHundredProduct(ProductDTO productDTO);
}
