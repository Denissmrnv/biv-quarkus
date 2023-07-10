package edu.my.controller;

import edu.my.dto.CategoryDTO;
import edu.my.service.CategoryService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Tag(name = "Category Resource", description = "Category REST APIs")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Path("/categories")
    @Counted(name = "performedChecksGetAllCategories", description = "How many requests of all categories were made.")
    @Timed(name = "checksTimerGetAllCategories", description = "A measure of how long it takes to complete a query of all categories.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getAllCategories",
            summary = "Get all Categories",
            description = "Get all categories inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getAllCategories()  {
        return Response.ok(categoryService.getAllCategories()).build();
    }

    @GET
    @Path("/categories/{id}")
    @Counted(name = "performedChecksGetOneCategory", description = "How many requests of one category were made.")
    @Timed(name = "checksTimerGetOneCategory", description = "A measure of how long it takes to complete a query of one category.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getCategoryById",
            summary = "Get Category by id",
            description = "Get one category inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getCategoryById(@PathParam("id") Long id)  {
        return Response.ok(categoryService.getCategory(id)).build();
    }

    @POST
    @Path("/categories")
    @Counted(name = "performedChecksAddCategory", description = "How many category additions have been made.")
    @Timed(name = "checksTimerAddCategory", description = "A measure of how long it takes to complete a category addition.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "addCategory",
            summary = "Add a new Category",
            description = "Add a new category to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Category is added",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response addCategory(
            @RequestBody(
                    description = "Category to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CategoryDTO.class))
            )
            CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return Response.status(Response.Status.CREATED).entity(categoryDTO).build();
    }

    @DELETE
    @Path("/categories/{id}")
    @Counted(name = "performedChecksDeleteCategory", description = "How many category deleted have been made.")
    @Timed(name = "checksTimerDeleteCategory", description = "A measure of how long it takes to complete a category delete.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "deleteCategory",
            summary = "Delete an existing Category",
            description = "Delete a Category inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Category is deleted",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response deleteCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/categories/{id}")
    @Counted(name = "performedChecksUpdateCategory", description = "How many category updated have been made.")
    @Timed(name = "checksTimerUpdateCategory", description = "A measure of how long it takes to complete a category update.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "updateCategory",
            summary = "Update an existing Category",
            description = "Update a Category inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Category is updated",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response updateCategory(
            @Parameter(
                    description = "Category id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Category",
                    required = true
            )
            CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return Response.ok(categoryDTO).build();
    }
}
