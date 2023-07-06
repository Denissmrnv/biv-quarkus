package edu.my.controller;

import edu.my.entity.Category;
import edu.my.service.CategoryService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categories")
    public List<Category> getAllCategories()  {
        return categoryService.getAllCategories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categories/{id}")
    public Category getCategoryById(@PathParam("id") Long id)  {
        return categoryService.getCategory(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/categories")
    public String addCategory(Category category) {
        categoryService.saveCategory(category);
        return "Category is added";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categories/{id}")
    @Transactional
    public String deleteCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
        return "Category is deleted";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/categories/{id}")
    @Transactional
    public String updateCategory(@PathParam("id") long id, Category category) {
        categoryService.updateCategory(id, category);
        return "Category is updated";
    }
}
