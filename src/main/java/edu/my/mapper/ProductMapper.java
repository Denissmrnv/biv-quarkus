package edu.my.mapper;

import edu.my.dto.ProductDTO;
import edu.my.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

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
