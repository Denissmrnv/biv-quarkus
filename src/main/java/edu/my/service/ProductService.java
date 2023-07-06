package edu.my.service;

import edu.my.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProduct(long id);
    public void deleteProduct(long id);
    public void updateProduct(long id, Product product);
    public void saveProduct(Product product);
}
