package edu.my.mapper;

import edu.my.dto.characteristic.CharacteristicRequestDTO;
import edu.my.dto.characteristic.CharacteristicResponseDTO;
import edu.my.dto.product.ProductRequestDTO;
import edu.my.dto.product.ProductResponseDTO;
import edu.my.entity.Characteristic;
import edu.my.entity.Product;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CharacteristicMapper.class, CategoryMapper.class}
)
public interface ProductMapper {
    @Named("productResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category", qualifiedByName = "categoryResponseDTOMapper")
    @Mapping(target = "characteristicSet", source = "characteristicSet", qualifiedByName = "characteristicResponseDTOMapper")
    ProductResponseDTO toResponseDTO(Product product);

    @InheritConfiguration
    @Named("productListResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    default List<ProductResponseDTO> toResponseDTO(List<Product> productList) {

        List<ProductResponseDTO> resultSet = new ArrayList<>();

        for (Product product: productList) {

            ProductResponseDTO productResponseDTO = toResponseDTO(product);
            resultSet.add(productResponseDTO);
        }
        return resultSet;
    }

    @Named("productRequestDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "category", source = "category", qualifiedByName = "categoryResponseDTOMapper")
    @Mapping(target = "characteristicSet", source = "characteristicSet", qualifiedByName = "characteristicRequestDTOMapper")

    Product toEntity(ProductRequestDTO productRequestDTO);

    @InheritConfiguration
    @Named("productListRequestDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    default List<Product> toEntity(List<ProductRequestDTO> productRequestDTOList) {

        List<Product> resultSet = new ArrayList<>();

        for (ProductRequestDTO productRequestDTO: productRequestDTOList) {

            Product product = toEntity(productRequestDTO);
            resultSet.add(product);
        }
        return resultSet;
    }
}
