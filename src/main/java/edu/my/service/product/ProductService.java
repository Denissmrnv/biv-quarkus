package edu.my.service.product;

import edu.my.entity.Characteristic;
import edu.my.repository.CharacteristicRepository;
import edu.my.repository.ProductRepository;
import edu.my.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;
    @Inject
    CharacteristicRepository characteristicRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll().list();
    }

    public Product getProduct(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(long id, Product product) {
        Product productSearch = productRepository.findById(id);

        productSearch.setCategory(product.getCategory());
        productSearch.setDescription(product.getDescription());
        productSearch.setPrice(product.getPrice());
        productSearch.setName(product.getName());

        Set<Characteristic> characteristicSetDTO = product.getCharacteristicSet();

        for (Characteristic characteristic: characteristicSetDTO) {
            Characteristic characteristicSearch = characteristicRepository.findById(characteristic.getId());
            characteristicSearch.setName(characteristic.getName());
            characteristicSearch.setMeaning(characteristic.getMeaning());
            characteristicSearch.setProduct(product);
        }
    }

    @Transactional
    public void saveProduct(Product product) {
        Set<Characteristic> characteristicSet = product.getCharacteristicSet();
        for (Characteristic characteristic : characteristicSet) {
            characteristic.setProduct(product);
        }
        productRepository.persist(product);
    }

    @Transactional
    public void saveOneHundredProduct(Product product) {

        for (int i = 0; i < 100; i++) {
            Product productNew = new Product();
            productNew.setCategory(product.getCategory());
            productNew.setDescription(product.getDescription());
            productNew.setPrice(product.getPrice());
            productNew.setCharacteristicSet(product.getCharacteristicSet());
            productNew.setName(product.getName() + " " + i);

            productRepository.persist(productNew);
        }
    }
}
