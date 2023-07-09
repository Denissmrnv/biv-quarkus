package edu.my.dto;

import edu.my.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicDTO {
    private Long id;
    private String name;
    private String beaning;
    private Product product;
}
