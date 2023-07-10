package edu.my.dto;

import edu.my.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CharacteristicDTO", description = "Characteristic representation")
public class CharacteristicDTO {
    @Schema(description = "Characteristic id")
    private Long id;
    @Schema(description = "Characteristic name")
    private String name;
    @Schema(description = "Characteristic beaning")
    private String beaning;
    @Schema(description = "Characteristic object Product")
    private Product product;
}
