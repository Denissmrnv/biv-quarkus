package edu.my.dto.characteristic;

import edu.my.dto.product.ProductRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CharacteristicRequestDTO", description = "Information for creating/updating a characteristic")
public class CharacteristicRequestDTO {
    @NotNull
    @Schema(description = "Characteristic name")
    private String name;
    @NotNull
    @Schema(description = "Characteristic meaning")
    private String meaning;
    @Schema(description = "Characteristic object Product")
    private ProductRequestDTO product;
}
