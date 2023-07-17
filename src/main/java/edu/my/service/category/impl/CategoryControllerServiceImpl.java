package edu.my.service.category.impl;

import edu.my.dto.category.CategoryDTO;
import edu.my.service.category.CategoryControllerService;
import edu.my.service.category.CategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoryControllerServiceImpl implements CategoryControllerService {
    @Inject
    CategoryService categoryService;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public CategoryDTO getCategory(long id) {
        return categoryService.getCategory(id);
    }

    @Override
    public void deleteCategory(long id) {
        categoryService.deleteCategory(id);
    }

    @Override
    public void updateCategory(long id, CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
    }

    @Override
    public void saveCategory(CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
    }
}
