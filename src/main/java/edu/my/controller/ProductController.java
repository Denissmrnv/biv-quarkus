package edu.my.controller;

import edu.my.dto.ProductDTO;
import edu.my.service.ProductService;
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
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Path("/products")
    @Counted(name = "performedChecksGetAllProducts", description = "How many requests of all products were made.")
    @Timed(name = "checksTimerGetAllProducts", description = "A measure of how long it takes to complete a query of all products.", unit = MetricUnits.MILLISECONDS)
    public List<ProductDTO> getAllProducts()  {
        return productService.getAllProducts();
    }

    @GET
    @Path("/products/{id}")
    @Counted(name = "performedChecksGetOneProduct", description = "How many requests of one product were made.")
    @Timed(name = "checksTimerGetOneProduct", description = "A measure of how long it takes to complete a query of one product.", unit = MetricUnits.MILLISECONDS)
    public ProductDTO getProductById(@PathParam("id") Long id)  {
        return productService.getProduct(id);
    }

    @POST
    @Path("/products")
    @Counted(name = "performedChecksAddProduct", description = "How many product additions have been made.")
    @Timed(name = "checksTimerAddProduct", description = "A measure of how long it takes to complete a product addition.", unit = MetricUnits.MILLISECONDS)
    public String addProduct(ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return "Product is added";
    }

    @DELETE
    @Path("/products/{id}")
    @Counted(name = "performedChecksDeleteProduct", description = "How many product deleted have been made.")
    @Timed(name = "checksTimerDeleteProduct", description = "A measure of how long it takes to complete a product delete.", unit = MetricUnits.MILLISECONDS)
    public String deleteProduct(@PathParam("id") long id) {
        productService.deleteProduct(id);
        return "Product is deleted";
    }

    @PUT
    @Path("/products/{id}")
    @Counted(name = "performedChecksUpdateProduct", description = "How many product updated have been made.")
    @Timed(name = "checksTimerUpdateProduct", description = "A measure of how long it takes to complete a product update.", unit = MetricUnits.MILLISECONDS)
    public String updateProduct(@PathParam("id") long id, ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return "Product is updated";
    }
}
