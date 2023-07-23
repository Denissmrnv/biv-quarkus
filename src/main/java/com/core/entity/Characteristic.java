package com.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characteristics")
@Getter
@Setter
@NoArgsConstructor
public class Characteristic extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "meaning")
    private String meaning;
    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private Product product;
}
