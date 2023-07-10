package edu.my.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CategoryDTO", description = "Category representation")
public class CategoryDTO {
    @Schema(description = "Category id")
    private Long id;
    @Schema(description = "Category name")
    private String name;
}
