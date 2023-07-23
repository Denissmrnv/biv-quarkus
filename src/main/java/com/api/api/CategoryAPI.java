package com.api.api;

import com.api.dto.category.CategoryRequestDTO;
import com.api.dto.category.CategoryResponseDTO;
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
                    schema = @Schema(implementation = CategoryResponseDTO.class)
            )
    )
    @GET
    @Path("/categories")
    Response getAllCategories();

    @GET
    @Path("/categories/{code}")
    @Operation(
            operationId = "getCategoryByCode",
            summary = "Get Category by code",
            description = "Get one category inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CategoryResponseDTO.class)
            )
    )
    Response getCategoryByCode(
            @Parameter(
                    description = "Category code",
                    required = true
            )
            @PathParam("code") Long code
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
                    schema = @Schema(implementation = CategoryResponseDTO.class)
            )
    )
    Response addCategory(
            @RequestBody(
                    description = "Category to create",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = CategoryRequestDTO.class)
                    )
            )
            CategoryRequestDTO categoryRequestDTO);

    @DELETE
    @Path("/categories/{code}")
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
                    schema = @Schema(implementation = CategoryResponseDTO.class)
            )
    )
    Response deleteCategory(
            @Parameter(
                    description = "Category code",
                    required = true
            )
            @PathParam("code") long code
    );

    @PUT
    @Path("/categories/{code}")
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
                    schema = @Schema(implementation = CategoryResponseDTO.class)
            )
    )
    Response updateCategory(
            @Parameter(
                    description = "Category code",
                    required = true
            )
            @PathParam("code") long code,
            @Parameter(
                    description = "Updated Category",
                    required = true
            )
            CategoryRequestDTO categoryRequestDTO);
}