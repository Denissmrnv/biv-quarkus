package edu.my.dto.product;

import edu.my.entity.Category;
import edu.my.entity.Characteristic;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Float price;
    private String description;
    private Category category;
    private Set<Characteristic> characteristicSet;
}
