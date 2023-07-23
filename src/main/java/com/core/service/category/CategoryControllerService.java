package com.core.service.category;

import com.api.dto.category.CategoryRequestDTO;
import com.api.dto.category.CategoryResponseDTO;

import java.util.List;


public interface CategoryControllerService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategory(long code);
    void deleteCategory(long code);
    void updateCategory(long code, CategoryRequestDTO categoryRequestDTO);
    void saveCategory(CategoryRequestDTO categoryRequestDTO);
}
