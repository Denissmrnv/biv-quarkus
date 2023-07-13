package edu.my.mapper;

import edu.my.dto.ProductDTO;
import edu.my.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTO(List<Product> productList);
    Product toEntity(ProductDTO productDTO);
    List<Product> toEntity(List<ProductDTO> productDTOList);
}
