package edu.my.service.category;

import edu.my.dto.category.CategoryDTO;
import edu.my.mapper.CategoryMapper;
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
    @Inject
    CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toDTO(categoryRepository.findAll().list());
    }

    public CategoryDTO getCategory(long id) {
        return categoryMapper.toDTO(categoryRepository.findById(id));
    }

    @Transactional
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    public void updateCategory(long id, CategoryDTO categoryDTO) {
        Category categorySearch = categoryRepository.findById(id);
        categorySearch.setName(categoryDTO.getName());
    }

    @Transactional
    public void saveCategory(CategoryDTO categoryDTO) {
        categoryRepository.persist(categoryMapper.toEntity(categoryDTO));
    }
}
