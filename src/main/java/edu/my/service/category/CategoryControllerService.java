package edu.my.service.category;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.dto.category.CategoryResponseDTO;

import java.util.List;


public interface CategoryControllerService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategory(long id);
    void deleteCategory(long id);
    void updateCategory(long id, CategoryRequestDTO categoryRequestDTO);
    void saveCategory(CategoryRequestDTO categoryRequestDTO);
}
