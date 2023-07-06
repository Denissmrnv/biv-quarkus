package edu.my.service.impl;

import edu.my.dao.CategoryRepository;
import edu.my.entity.Category;
import edu.my.service.CategoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll().list();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(long id, Category category) {
        Category categorySearch = categoryRepository.findById(id);
        categorySearch.setName(category.getName());
        categoryRepository.persist(categorySearch);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.persist(category);
    }
}
