package edu.my.controller;

import edu.my.api.CategoryAPI;
import edu.my.dto.category.CategoryRequestDTO;
import edu.my.service.category.CategoryControllerService;
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
public class CategoryController implements CategoryAPI {
    @Inject
    CategoryControllerService categoryControllerService;

    @Counted(name = "performedChecksGetAllCategories", description = "How many requests of all categories were made.")
    @Timed(name = "checksTimerGetAllCategories", description = "A measure of how long it takes to complete a query of all categories.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getAllCategories()  {
        return Response.ok(categoryControllerService.getAllCategories()).build();
    }

    @Counted(name = "performedChecksGetOneCategory", description = "How many requests of one category were made.")
    @Timed(name = "checksTimerGetOneCategory", description = "A measure of how long it takes to complete a query of one category.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getCategoryByCode(@PathParam("code") Long code)  {
        return Response.ok(categoryControllerService.getCategory(code)).build();
    }

    @Counted(name = "performedChecksAddCategory", description = "How many category additions have been made.")
    @Timed(name = "checksTimerAddCategory", description = "A measure of how long it takes to complete a category addition.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response addCategory(CategoryRequestDTO categoryRequestDTO) {
        categoryControllerService.saveCategory(categoryRequestDTO);
        return Response.status(Response.Status.CREATED).entity(categoryControllerService.getAllCategories()).build();
    }

    @Counted(name = "performedChecksDeleteCategory", description = "How many category deleted have been made.")
    @Timed(name = "checksTimerDeleteCategory", description = "A measure of how long it takes to complete a category delete.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response deleteCategory(@PathParam("code") long code) {
        categoryControllerService.deleteCategory(code);
        return Response.noContent().build();
    }

    @Counted(name = "performedChecksUpdateCategory", description = "How many category updated have been made.")
    @Timed(name = "checksTimerUpdateCategory", description = "A measure of how long it takes to complete a category update.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response updateCategory(@PathParam("code") long code, CategoryRequestDTO categoryRequestDTO) {
        categoryControllerService.updateCategory(code, categoryRequestDTO);
        return Response .ok(categoryRequestDTO).build();
    }
}
