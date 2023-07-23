package com.core.service.category.impl;

import com.api.dto.category.CategoryRequestDTO;
import com.api.dto.category.CategoryResponseDTO;
import com.core.mapper.CategoryMapper;
import com.core.service.category.CategoryControllerService;
import com.core.service.category.CategoryService;
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
    public CategoryResponseDTO getCategory(long code) {
        return categoryMapper.toResponseDTO(categoryService.getCategory(code));
    }

    @Override
    public void deleteCategory(long code) {
        categoryService.deleteCategory(code);
    }

    @Override
    public void updateCategory(long code, CategoryRequestDTO categoryRequestDTO) {
        categoryService.updateCategory(code, categoryMapper.toEntity(categoryRequestDTO));
    }

    @Override
    public void saveCategory(CategoryRequestDTO categoryRequestDTO) {
        categoryService.saveCategory(categoryMapper.toEntity(categoryRequestDTO));
    }
}
