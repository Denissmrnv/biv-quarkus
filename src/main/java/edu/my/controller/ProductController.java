package edu.my.controller;

import edu.my.dto.product.ProductDTO;
import edu.my.mapper.ProductMapper;
import edu.my.service.ProductService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Path("/products")
    public List<ProductDTO> getAllProducts()  {
        return productService.getAllProducts();
    }

    @GET
    @Path("/products/{id}")
    public ProductDTO getProductById(@PathParam("id") Long id)  {
        return productService.getProduct(id);
    }

    @POST
    @Path("/products")
    public String addProduct(ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return "Product is added";
    }

    @DELETE
    @Path("/products/{id}")
    public String deleteProduct(@PathParam("id") long id) {
        productService.deleteProduct(id);
        return "Product is deleted";
    }

    @PUT
    @Path("/products/{id}")
    public String updateProduct(@PathParam("id") long id, ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return "Product is updated";
    }
}
