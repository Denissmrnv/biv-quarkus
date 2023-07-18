package edu.my.controller;

import edu.my.api.ProductAPI;
import edu.my.dto.product.ProductRequestDTO;
import edu.my.service.product.ProductControllerService;
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
public class ProductController implements ProductAPI {
    @Inject
    ProductControllerService productControllerService;

    @Counted(name = "performedChecksGetAllProducts", description = "How many requests of all products were made.")
    @Timed(name = "checksTimerGetAllProducts", description = "A measure of how long it takes to complete a query of all products.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getAllProducts()  {
        return Response.ok(productControllerService.getAllProducts()).build();
    }

    @Counted(name = "performedChecksGetOneProduct", description = "How many requests of one product were made.")
    @Timed(name = "checksTimerGetOneProduct", description = "A measure of how long it takes to complete a query of one product.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getProductById(@PathParam("id") Long id)  {
        return Response.ok(productControllerService.getProduct(id)).build();
    }

    @Counted(name = "performedChecksAddProduct", description = "How many product additions have been made.")
    @Timed(name = "checksTimerAddProduct", description = "A measure of how long it takes to complete a product addition.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response addProduct(ProductRequestDTO productRequestDTO) {
        productControllerService.saveProduct(productRequestDTO);
        return Response.status(Response.Status.CREATED).entity(productControllerService.getAllProducts()).build();
    }

    @Counted(name = "performedChecksDeleteProduct", description = "How many product deleted have been made.")
    @Timed(name = "checksTimerDeleteProduct", description = "A measure of how long it takes to complete a product delete.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response deleteProduct(@PathParam("id") long id) {
        productControllerService.deleteProduct(id);
        return Response.noContent().build();
    }

    @Counted(name = "performedChecksUpdateProduct", description = "How many product updated have been made.")
    @Timed(name = "checksTimerUpdateProduct", description = "A measure of how long it takes to complete a product update.", unit = MetricUnits.MILLISECONDS)
    @Override
    public String updateProduct(@PathParam("id") long id, ProductRequestDTO productRequestDTO) {
        productControllerService.updateProduct(id, productRequestDTO);
        return "Product is updated";
    }

    @Counted(name = "performedChecksAddOneHundredProduct", description = "How many one hundred products additions have been made.")
    @Timed(name = "checksTimerDddOneHundredProduct", description = "A measure of how long it takes to complete a one hundred products addition.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response addOneHundredProduct(ProductRequestDTO productRequestDTO) {
        productControllerService.saveOneHundredProduct(productRequestDTO);
        return Response.status(Response.Status.CREATED).entity(productControllerService.getAllProducts()).build();
    }
}
