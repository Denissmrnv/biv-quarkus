package edu.my.controller;

import edu.my.dto.ProductDTO;
import edu.my.service.ProductService;
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
@Tag(name = "Product Resource", description = "Product REST APIs")
public class ProductController {
    @Inject
    ProductService productService;

    @GET
    @Path("/products")
    @Counted(name = "performedChecksGetAllProducts", description = "How many requests of all products were made.")
    @Timed(name = "checksTimerGetAllProducts", description = "A measure of how long it takes to complete a query of all products.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getAllProducts",
            summary = "Get all Products",
            description = "Get all products inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getAllProducts()  {
        return Response.ok(productService.getAllProducts()).build();
    }

    @GET
    @Path("/products/{id}")
    @Counted(name = "performedChecksGetOneProduct", description = "How many requests of one product were made.")
    @Timed(name = "checksTimerGetOneProduct", description = "A measure of how long it takes to complete a query of one product.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getProductById",
            summary = "Get Product by id",
            description = "Get one product inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getProductById(@PathParam("id") Long id)  {
        return Response.ok(productService.getProduct(id)).build();
    }

    @POST
    @Path("/products")
    @Counted(name = "performedChecksAddProduct", description = "How many product additions have been made.")
    @Timed(name = "checksTimerAddProduct", description = "A measure of how long it takes to complete a product addition.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "addProduct",
            summary = "Add a new Product",
            description = "Add a new product to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Product is added",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response addProduct(
            @RequestBody(
                    description = "Product to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProductDTO.class))
            )
            ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return Response.status(Response.Status.CREATED).entity(productService.getAllProducts()).build();
    }

    @DELETE
    @Path("/products/{id}")
    @Counted(name = "performedChecksDeleteProduct", description = "How many product deleted have been made.")
    @Timed(name = "checksTimerDeleteProduct", description = "A measure of how long it takes to complete a product delete.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "deleteProduct",
            summary = "Delete an existing Product",
            description = "Delete a product inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Product is deleted",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response deleteProduct(@PathParam("id") long id) {
        productService.deleteProduct(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/products/{id}")
    @Counted(name = "performedChecksUpdateProduct", description = "How many product updated have been made.")
    @Timed(name = "checksTimerUpdateProduct", description = "A measure of how long it takes to complete a product update.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "updateProduct",
            summary = "Update an existing Product",
            description = "Update a product inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Product is updated",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public String updateProduct(
            @Parameter(
                    description = "Product id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Product",
                    required = true
            )
            ProductDTO productDTO) {
        productService.updateProduct(id, productDTO);
        return "Product is updated";
    }
}
