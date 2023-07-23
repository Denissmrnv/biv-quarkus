package com.api.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "CategoryRequestDTO", description = "Information for creating/updating a category")
public class CategoryRequestDTO {
    @Schema(description = "Category name")
    private String name;
    @Schema(description = "Category code")
    private Long code;
}
