package com.core.mapper;

import com.api.dto.category.CategoryRequestDTO;
import com.api.dto.category.CategoryResponseDTO;
import com.core.entity.Category;
import org.mapstruct.*;

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

    @Named("categoryUpdate")
    @Mapping(target = "id", source = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "code", source = "code")
    void update(Category categoryCur, @MappingTarget Category categoryUpd);
}
