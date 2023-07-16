package edu.my.dto.characteristic;

import edu.my.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CharacteristicDTO", description = "Characteristic representation")
public class CharacteristicDTO {
    @Schema(description = "Characteristic id")
    private Long id;
    @NotNull
    @Schema(description = "Characteristic name")
    private String name;
    @NotNull
    @Schema(description = "Characteristic meaning")
    private String meaning;
    @Schema(description = "Characteristic object Product")
    private Product product;
}
