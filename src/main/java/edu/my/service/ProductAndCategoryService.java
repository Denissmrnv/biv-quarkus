package edu.my.service;

import edu.my.dto.product.ProductDTO;

public interface ProductAndCategoryService {
    public void saveProductAndCharacteristic(ProductDTO productDTO);
    public void updateProductAndCharacteristic(long id, ProductDTO productDTO);

}
