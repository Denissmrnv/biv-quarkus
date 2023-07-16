package edu.my.service;

import edu.my.dto.category.CategoryDTO;

import java.util.List;


public interface CategoryService {
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO getCategory(long id);
    public void deleteCategory(long id);
    public void updateCategory(long id, CategoryDTO categoryDTO);
    public void saveCategory(CategoryDTO categoryDTO);
}
