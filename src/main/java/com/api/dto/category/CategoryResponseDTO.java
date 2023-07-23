package com.api.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CategoryResponseDTO", description = "Category information")
public class CategoryResponseDTO {
    @Schema(description = "Category id")
    private Long id;
    @Schema(description = "Category name")
    private String name;
    @Schema(description = "Category code")
    private Long code;
}
