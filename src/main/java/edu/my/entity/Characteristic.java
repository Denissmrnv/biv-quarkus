package edu.my.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "characteristics")
public class Characteristic extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "name")
    public String name;
    @Column(name = "beaning")
    public String beaning;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
//    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "ID_CHARACTERISTIC"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT"))
    @JoinColumn(name = "id_product")
    private Product product;

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

    public String getBeaning() {
        return beaning;
    }

    public void setBeaning(String beaning) {
        this.beaning = beaning;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
