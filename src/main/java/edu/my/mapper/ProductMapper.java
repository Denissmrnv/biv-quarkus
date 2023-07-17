package edu.my.mapper;

import edu.my.dto.product.ProductRequestDTO;
import edu.my.dto.product.ProductResponseDTO;
import edu.my.entity.Product;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CharacteristicMapper.class}
)
public interface ProductMapper {
    @Named("productResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "characteristicSet", source = "characteristicSet")
    ProductResponseDTO toResponseDTO(Product product);

    default List<ProductResponseDTO> toResponseDTO(List<Product> productList) {
        List<ProductResponseDTO> result = new ArrayList<>();
        for (Product product: productList) {
            result.add(toResponseDTO(product));
        }
        return result;
    }

    @Named("productRequestDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "characteristicSet", source = "characteristicSet")
    Product toEntity(ProductRequestDTO productRequestDTO);
}
