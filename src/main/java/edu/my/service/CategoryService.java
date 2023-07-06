package edu.my.service;

import edu.my.entity.Category;

import java.util.List;


public interface CategoryService {
    public List<Category> getAllCategories();
    public Category getCategory(long id);
    public void deleteCategory(long id);
    public void updateCategory(long id, Category category);
    public void saveCategory(Category category);
}
