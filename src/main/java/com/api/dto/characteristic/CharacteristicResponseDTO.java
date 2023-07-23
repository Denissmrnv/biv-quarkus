package com.api.dto.characteristic;

import com.api.dto.product.ProductResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CharacteristicResponseDTO", description = "Characteristic information")
public class CharacteristicResponseDTO {
    @Schema(description = "Characteristic id")
    private Long id;
    @Schema(description = "Characteristic name")
    private String name;
    @Schema(description = "Characteristic meaning")
    private String meaning;
    @Schema(description = "Characteristic object Product")
    @JsonIgnore
    private ProductResponseDTO product;
}
