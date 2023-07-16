package edu.my.service.impl;

import edu.my.dto.category.CategoryDTO;
import edu.my.mapper.CategoryMapper;
import edu.my.repository.CategoryRepository;
import edu.my.entity.Category;
import edu.my.service.CategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toDTO(categoryRepository.findAll().list());
    }

    @Override
    public CategoryDTO getCategory(long id) {
        return categoryMapper.toDTO(categoryRepository.findById(id));
    }

    @Override
    @Transactional
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateCategory(long id, CategoryDTO categoryDTO) {
        Category categorySearch = categoryRepository.findById(id);
        categorySearch.setName(categoryDTO.getName());
    }

    @Override
    @Transactional
    public void saveCategory(CategoryDTO categoryDTO) {
        categoryRepository.persist(categoryMapper.toEntity(categoryDTO));
    }
}
