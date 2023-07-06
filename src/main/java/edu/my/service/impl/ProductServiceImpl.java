package edu.my.service.impl;

import edu.my.dao.CharacteristicRepository;
import edu.my.dao.ProductRepository;
import edu.my.entity.Product;
import edu.my.service.ProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().list();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProduct(long id, Product product) {
        Product productSearch = productRepository.findById(id);
        productSearch.setCategory(product.getCategory());
        productSearch.setDescription(product.getDescription());
        productSearch.setPrice(product.getPrice());
        productSearch.setCharacteristicSet(product.getCharacteristicSet());
        productSearch.setName(product.getName());
        productRepository.persist(product);
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.persist(product);
    }
}
