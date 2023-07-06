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

    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinTable(name = "products", joinColumns = @JoinColumn(name = "ID_CHARACTERISTIC"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT"))
    private Product product;
}
