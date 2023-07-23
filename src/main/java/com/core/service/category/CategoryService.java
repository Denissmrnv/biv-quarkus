package com.core.service.category;

import com.core.repository.CategoryRepository;
import com.core.entity.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll().list();
    }

    @Transactional
    public Category getCategory(long code) {
        return categoryRepository.findByCode(code);
    }

    @Transactional
    public void deleteCategory(long code) {
        categoryRepository.deleteByCode(code);
    }

    @Transactional
    public void updateCategory(long code, Category category) {
        Category categorySearch = categoryRepository.findByCode(code);
        categorySearch.setName(category.getName());
        categorySearch.setCode(category.getCode());
    }

    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.persist(category);
    }
}
