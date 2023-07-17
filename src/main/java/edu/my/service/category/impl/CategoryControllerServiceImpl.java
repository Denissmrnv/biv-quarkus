package edu.my.service.category.impl;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.dto.category.CategoryResponseDTO;
import edu.my.mapper.CategoryMapper;
import edu.my.service.category.CategoryControllerService;
import edu.my.service.category.CategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoryControllerServiceImpl implements CategoryControllerService {
    @Inject
    CategoryService categoryService;
    @Inject
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryMapper.toResponseDTO(categoryService.getAllCategories());
    }

    @Override
    public CategoryResponseDTO getCategory(long id) {
        return categoryMapper.toResponseDTO(categoryService.getCategory(id));
    }

    @Override
    public void deleteCategory(long id) {
        categoryService.deleteCategory(id);
    }

    @Override
    public void updateCategory(long id, CategoryRequestDTO categoryRequestDTO) {
        categoryService.updateCategory(id, categoryMapper.toEntity(categoryRequestDTO));
    }

    @Override
    public void saveCategory(CategoryRequestDTO categoryRequestDTO) {
        categoryService.saveCategory(categoryMapper.toEntity(categoryRequestDTO));
    }
}
