package edu.my.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "characteristics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Characteristic extends PanacheEntityBase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "beaning")
    private String beaning;
    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private Product product;
}
