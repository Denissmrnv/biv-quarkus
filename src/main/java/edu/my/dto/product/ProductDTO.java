package edu.my.dto.product;

import edu.my.dto.characteristic.CharacteristicDTO;
import edu.my.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "ProductDTO", description = "Product representation")
public class ProductDTO {
    @Schema(description = "Product id")
    private Long id;
    @NotNull
    @Schema(description = "Product name")
    private String name;
    @NotNull
    @Schema(description = "Product price")
    private Float price;
    @Schema(description = "Product description")
    private String description;
    @Schema(description = "Product object Category")
    private Category category;
    @Schema(description = "Product set of characteristic")
    private Set<CharacteristicDTO> characteristicSet;
}
