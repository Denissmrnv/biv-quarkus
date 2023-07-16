package edu.my.mapper;

import edu.my.dto.product.ProductDTO;
import edu.my.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CharacteristicMapper.class}
)
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTO(List<Product> productList);
    Product toEntity(ProductDTO productDTO);
    List<Product> toEntity(List<ProductDTO> productDTOList);
}
