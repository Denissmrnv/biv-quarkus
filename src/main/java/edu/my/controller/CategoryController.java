package edu.my.controller;

import edu.my.dto.CategoryDTO;
import edu.my.entity.Category;
import edu.my.service.CategoryService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Path("/categories")
    @Counted(name = "performedChecksGetAllCategories", description = "How many requests of all categories were made.")
    @Timed(name = "checksTimerGetAllCategories", description = "A measure of how long it takes to complete a query of all categories.", unit = MetricUnits.MILLISECONDS)
    public List<CategoryDTO> getAllCategories()  {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("/categories/{id}")
    @Counted(name = "performedChecksGetOneCategory", description = "How many requests of one category were made.")
    @Timed(name = "checksTimerGetOneCategory", description = "A measure of how long it takes to complete a query of one category.", unit = MetricUnits.MILLISECONDS)
    public CategoryDTO getCategoryById(@PathParam("id") Long id)  {
        return categoryService.getCategory(id);
    }

    @POST
    @Path("/categories")
    @Counted(name = "performedChecksAddCategory", description = "How many category additions have been made.")
    @Timed(name = "checksTimerAddCategory", description = "A measure of how long it takes to complete a category addition.", unit = MetricUnits.MILLISECONDS)
    public String addCategory(CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return "Category is added";
    }

    @DELETE
    @Path("/categories/{id}")
    @Counted(name = "performedChecksDeleteCategory", description = "How many category deleted have been made.")
    @Timed(name = "checksTimerDeleteCategory", description = "A measure of how long it takes to complete a category delete.", unit = MetricUnits.MILLISECONDS)
    public String deleteCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
        return "Category is deleted";
    }

    @PUT
    @Path("/categories/{id}")
    @Counted(name = "performedChecksUpdateCategory", description = "How many category updated have been made.")
    @Timed(name = "checksTimerUpdateCategory", description = "A measure of how long it takes to complete a category update.", unit = MetricUnits.MILLISECONDS)
    public String updateCategory(@PathParam("id") long id, CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return "Category is updated";
    }
}
