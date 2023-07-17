package edu.my.service.category;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.dto.category.CategoryResponseDTO;

import java.util.List;


public interface CategoryControllerService {
    public List<CategoryResponseDTO> getAllCategories();
    public CategoryResponseDTO getCategory(long id);
    public void deleteCategory(long id);
    public void updateCategory(long id, CategoryRequestDTO categoryRequestDTO);
    public void saveCategory(CategoryRequestDTO categoryRequestDTO);
}
