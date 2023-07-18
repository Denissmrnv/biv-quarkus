package edu.my.repository;

import edu.my.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

    public Category findByCode(Long code) {
        return find("code = ?1", code).firstResultOptional().orElse(null);
    }

    public void deleteByCode(Long code) {
        delete("code = ?1", code);
    }
}
