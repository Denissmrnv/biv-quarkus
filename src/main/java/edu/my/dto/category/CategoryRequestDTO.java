package edu.my.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CategoryRequestDTO", description = "Information for creating/updating a category")
public class CategoryRequestDTO {
    @NotNull
    @Schema(description = "Category name")
    private String name;
    @Schema(description = "Category code")
    @NotNull
    private Long code;
}
