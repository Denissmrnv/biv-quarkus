package edu.my.mapper;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.dto.category.CategoryResponseDTO;
import edu.my.entity.Category;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    @Named("categoryResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "code", source = "code")
    CategoryResponseDTO toResponseDTO(Category category);

    @BeanMapping(ignoreByDefault = true)
    List<CategoryResponseDTO> toResponseDTO(List<Category> categoryList);

    @Named("categoryResponseDTOMapper")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "code", source = "code")
    Category toEntity(CategoryRequestDTO categoryRequestDTO);

    @BeanMapping(ignoreByDefault = true)
    List<Category> toEntity(List<CategoryRequestDTO> categoryRequestDTOList);

//    void update(Category cagegorySrc, @MappingTarget Category categoryUpd)
}
