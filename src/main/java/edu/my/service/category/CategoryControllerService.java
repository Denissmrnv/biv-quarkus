package edu.my.service.category;

import edu.my.dto.category.CategoryDTO;

import java.util.List;


public interface CategoryControllerService {
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO getCategory(long id);
    public void deleteCategory(long id);
    public void updateCategory(long id, CategoryDTO categoryDTO);
    public void saveCategory(CategoryDTO categoryDTO);
}
