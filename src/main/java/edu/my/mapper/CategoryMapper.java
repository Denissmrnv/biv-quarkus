package edu.my.mapper;

import edu.my.dto.category.CategoryDTO;
import edu.my.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    List<CategoryDTO> toDTO(List<Category> categoryList);
    Category toEntity(CategoryDTO categoryDTO);
    List<Category> toEntity(List<CategoryDTO> categoryDTOList);
}
