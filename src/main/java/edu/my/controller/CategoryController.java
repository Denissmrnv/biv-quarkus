package edu.my.controller;

import edu.my.api.CategoryAPI;
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

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class CategoryController implements CategoryAPI {
    @Inject
    CategoryService categoryService;

    @GET
    @Path("/categories")
    @Counted(name = "performedChecksGetAllCategories", description = "How many requests of all categories were made.")
    @Timed(name = "checksTimerGetAllCategories", description = "A measure of how long it takes to complete a query of all categories.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getAllCategories()  {
        return Response.ok(categoryService.getAllCategories()).build();
    }

    @GET
    @Path("/categories/{id}")
    @Counted(name = "performedChecksGetOneCategory", description = "How many requests of one category were made.")
    @Timed(name = "checksTimerGetOneCategory", description = "A measure of how long it takes to complete a query of one category.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getCategoryById(@PathParam("id") Long id)  {
        return Response.ok(categoryService.getCategory(id)).build();
    }

    @POST
    @Path("/categories")
    @Counted(name = "performedChecksAddCategory", description = "How many category additions have been made.")
    @Timed(name = "checksTimerAddCategory", description = "A measure of how long it takes to complete a category addition.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response addCategory(CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return Response.status(Response.Status.CREATED).entity(categoryService.getAllCategories()).build();
    }

    @DELETE
    @Path("/categories/{id}")
    @Counted(name = "performedChecksDeleteCategory", description = "How many category deleted have been made.")
    @Timed(name = "checksTimerDeleteCategory", description = "A measure of how long it takes to complete a category delete.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response deleteCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/categories/{id}")
    @Counted(name = "performedChecksUpdateCategory", description = "How many category updated have been made.")
    @Timed(name = "checksTimerUpdateCategory", description = "A measure of how long it takes to complete a category update.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response updateCategory(@PathParam("id") long id, CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return Response.ok(categoryDTO).build();
    }
}
