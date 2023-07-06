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
    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "ID_PRODUCT"), inverseJoinColumns = @JoinColumn(name = "ID_CATEGORY"))
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Characteristic> characteristicSet;

}
