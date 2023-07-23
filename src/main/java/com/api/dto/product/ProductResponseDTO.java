package com.api.dto.product;

import com.api.dto.category.CategoryResponseDTO;
import com.api.dto.characteristic.CharacteristicResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "ProductResponseDTO", description = "Product information")
public class ProductResponseDTO {
    @Schema(description = "Product id")
    private Long id;
    @Schema(description = "Product name")
    private String name;
    @Schema(description = "Product price")
    private Float price;
    @Schema(description = "Product description")
    private String description;
    @Schema(description = "Product object Category")
    private CategoryResponseDTO category;
    @Schema(description = "Product set of characteristic")
    private Set<CharacteristicResponseDTO> characteristicSet;
}
