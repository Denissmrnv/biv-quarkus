package edu.my.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "price")
    public Float price;
    @Column(name = "description")
    public String description;

    @OneToOne(fetch = FetchType.EAGER,optional=true)
//    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "ID_PRODUCT"), inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Characteristic> characteristicSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Characteristic> getCharacteristicSet() {
        return characteristicSet;
    }

    public void setCharacteristicSet(Set<Characteristic> characteristicSet) {
        this.characteristicSet = characteristicSet;
    }
}
