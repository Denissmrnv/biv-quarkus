package edu.my.repository;

import edu.my.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    public Category findByCode(Long code) {
        return (Category) find("SELECT c FROM Category c WHERE c.code = ?1", code);
    }

    public void deleteByCode(Long code) {
        delete("DELETE FROM Category WHERE code = ?1", code);
    }
}
