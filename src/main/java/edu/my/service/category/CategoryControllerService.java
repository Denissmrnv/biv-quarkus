package edu.my.service.category;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.dto.category.CategoryResponseDTO;

import java.util.List;


public interface CategoryControllerService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategory(long code);
    void deleteCategory(long code);
    void updateCategory(long code, CategoryRequestDTO categoryRequestDTO);
    void saveCategory(CategoryRequestDTO categoryRequestDTO);
}
