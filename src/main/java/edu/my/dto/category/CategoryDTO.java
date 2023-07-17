package edu.my.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CategoryDTO", description = "Category representation")
public class CategoryDTO {
    @Schema(description = "Category id")
    private Long id;
    @NotNull
    @Schema(description = "Category name")
    private String name;
    @Schema(description = "Category code")
    @NotNull
    private Long code;

}
