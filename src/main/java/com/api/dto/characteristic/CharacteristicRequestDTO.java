package com.api.dto.characteristic;

import com.api.dto.product.ProductRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CharacteristicRequestDTO", description = "Information for creating/updating a characteristic")
public class CharacteristicRequestDTO {
    @Schema(description = "Characteristic name")
    private String name;
    @Schema(description = "Characteristic meaning")
    private String meaning;
    @Schema(description = "Characteristic object Product")
    private ProductRequestDTO product;
}
