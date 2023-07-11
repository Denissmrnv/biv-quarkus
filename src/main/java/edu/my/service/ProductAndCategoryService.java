package edu.my.service;

import edu.my.dto.CharacteristicDTO;
import edu.my.dto.ProductDTO;

public interface ProductAndCategoryService {
    public void saveProductAndCharacteristic(ProductDTO productDTO);
    public void updateProductAndCharacteristic(long id, ProductDTO productDTO);

}
