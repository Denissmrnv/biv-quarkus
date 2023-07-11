package edu.my.controller;

import edu.my.dto.CharacteristicDTO;
import edu.my.dto.ProductDTO;
import edu.my.service.ProductAndCategoryService;
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

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
@Tag(name = "Product and Characteristic Resource", description = "Product and Characteristic REST APIs")
public class ProductAndCharacteristicController {
    @Inject
    ProductAndCategoryService productAndCategoryService;

    @POST
    @Path("/productsAndCharacteristic")
    @Counted(name = "performedChecksAddProductAndCharacteristic", description = "How many product and characteristic additions have been made.")
    @Timed(name = "checksTimerAddProductAndCharacteristic", description = "A measure of how long it takes to complete a product and characteristic addition.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "addProductAndCharacteristic",
            summary = "Add a new Product with Characteristic",
            description = "Add a new product with characteristic to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Product with Characteristic is added",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response addProductAndCharacteristic(
            @RequestBody(
                    description = "Product with Characteristic to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProductDTO.class))
            )
            ProductDTO productDTO) {
        productAndCategoryService.saveProductAndCharacteristic(productDTO);
        return Response.status(Response.Status.CREATED).build();

    }

    @PUT
    @Path("/productsAndCharacteristic/{id}")
    @Counted(name = "performedChecksUpdateProductAndCharacteristic", description = "How many product and characteristic updated have been made.")
    @Timed(name = "checksTimerUpdateProductAndCharacteristic", description = "A measure of how long it takes to complete a product and characteristic update.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "updateProductAndCharacteristic",
            summary = "Update an existing Product with Characteristic",
            description = "Update a Product with Characteristic inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Characteristic is updated",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response updateProductAndCharacteristic(
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
        productAndCategoryService.updateProductAndCharacteristic(id, productDTO);
        return Response.status(Response.Status.CREATED).build();
    }
}
