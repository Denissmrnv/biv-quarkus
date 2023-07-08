package edu.my.controller;

import edu.my.dto.CategoryDTO;
import edu.my.entity.Category;
import edu.my.service.CategoryService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public List<CategoryDTO> getAllCategories()  {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("/categories/{id}")
    public CategoryDTO getCategoryById(@PathParam("id") Long id)  {
        return categoryService.getCategory(id);
    }

    @POST
    @Path("/categories")
    public String addCategory(CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return "Category is added";
    }

    @DELETE
    @Path("/categories/{id}")
    public String deleteCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
        return "Category is deleted";
    }

    @PUT
    @Path("/categories/{id}")
    public String updateCategory(@PathParam("id") long id, CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return "Category is updated";
    }
}
