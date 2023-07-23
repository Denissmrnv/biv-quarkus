package com.api.dto.product;

import com.api.dto.category.CategoryRequestDTO;
import com.api.dto.characteristic.CharacteristicRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "ProductRequestDTO", description = "Information for creating/updating a product")
public class ProductRequestDTO {
    @Schema(description = "Product name")
    private String name;
    @Schema(description = "Product price")
    private Float price;
    @Schema(description = "Product description")
    private String description;
    @Schema(description = "Product set of characteristic")
    private Set<CharacteristicRequestDTO> characteristicSet;
    @Schema(description = "Product object Category")
    private CategoryRequestDTO category;
}
