package edu.my.dao;

import edu.my.entity.Characteristic;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CharacteristicRepository implements PanacheRepository<Characteristic> {
}
