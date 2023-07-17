package edu.my.service.category;

import edu.my.dto.category.CategoryRequestDTO;
import edu.my.repository.CategoryRepository;
import edu.my.entity.Category;
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

    public Category getCategory(long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    public void updateCategory(long id, Category category) {
        Category categorySearch = categoryRepository.findById(id);
        categorySearch.setName(category.getName());
        categorySearch.setCode(category.getCode());
    }

    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.persist(category);
    }
}
