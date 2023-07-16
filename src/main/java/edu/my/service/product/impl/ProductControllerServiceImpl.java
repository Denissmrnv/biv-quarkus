package edu.my.service.product.impl;

import edu.my.dto.product.ProductDTO;
import edu.my.service.product.ProductControllerService;
import edu.my.service.product.ProductService;
import jakarta.inject.Inject;

import java.util.List;

public class ProductControllerServiceImpl implements ProductControllerService {
    @Inject
    ProductService productService;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public ProductDTO getProduct(long id) {
        return productService.getProduct(id);
    }

    @Override
    public void deleteProduct(long id) {
        productService.deleteProduct(id);
    }

    @Override
    public void updateProduct(long id, ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        productService.saveProduct(productDTO);
    }

    @Override
    public void saveOneHundredProduct(ProductDTO productDTO) {
        productService.saveOneHundredProduct(productDTO);
    }
}
