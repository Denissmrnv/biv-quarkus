package edu.my.controller;

import edu.my.entity.Product;
import edu.my.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products")
    public List<Product> getAllProducts()  {
        return productService.getAllProducts();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    public Product getProductById(@PathParam("id") Long id)  {
        return productService.getProduct(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/products")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "Product is added";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    @Transactional
    public String deleteProduct(@PathParam("id") long id) {
        productService.deleteProduct(id);
        return "Product is deleted";
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{id}")
    @Transactional
    public String updateProduct(@PathParam("id") long id, Product product) {
        productService.updateProduct(id, product);
        return "Product is updated";
    }
}
