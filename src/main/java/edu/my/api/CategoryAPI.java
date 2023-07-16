package edu.my.api;

import edu.my.dto.category.CategoryDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@Tag(name = "Category Resource", description = "Category REST APIs")
public interface CategoryAPI {
    @Operation(
            operationId = "getAllCategories",
            summary = "Get all Categories",
            description = "Get all categories inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryDTO.class)
            )
    )
    @GET
    @Path("/categories")
    Response getAllCategories();

    @GET
    @Path("/categories/{id}")
    @Operation(
            operationId = "getCategoryById",
            summary = "Get Category by id",
            description = "Get one category inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryDTO.class)
            )
    )
    Response getCategoryById(
            @Parameter(
                    description = "Category id",
                    required = true
            )
            @PathParam("id") Long id
    );

    @POST
    @Path("/categories")
    @Operation(
            operationId = "addCategory",
            summary = "Add a new Category",
            description = "Add a new category to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Category is added",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryDTO.class)
            )
    )
    Response addCategory(
            @RequestBody(
                    description = "Category to create",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = CategoryDTO.class)
                    )
            )
            CategoryDTO categoryDTO);

    @DELETE
    @Path("/categories/{id}")
    @Operation(
            operationId = "deleteCategory",
            summary = "Delete an existing Category",
            description = "Delete a Category inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Category is deleted",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryDTO.class)
            )
    )
    Response deleteCategory(
            @Parameter(
                    description = "Category id",
                    required = true
            )
            @PathParam("id") long id
    );

    @PUT
    @Path("/categories/{id}")
    @Operation(
            operationId = "updateCategory",
            summary = "Update an existing Category",
            description = "Update a Category inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Category is updated",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryDTO.class)
            )
    )
    Response updateCategory(
            @Parameter(
                    description = "Category id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Category",
                    required = true
            )
            CategoryDTO categoryDTO);
}
