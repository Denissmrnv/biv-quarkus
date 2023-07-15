package edu.my.api;

import edu.my.dto.ProductDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@Tag(name = "Product Resource", description = "Product REST APIs")
public interface ProductApi {
    @GET
    @Path("/products")
    @Operation(
            operationId = "getAllProducts",
            summary = "Get all Products",
            description = "Get all products inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    Response getAllProducts();

    @GET
    @Path("/products/{id}")
    @Operation(
            operationId = "getProductById",
            summary = "Get Product by id",
            description = "Get one product inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    Response getProductById(
            @Parameter(
                    description = "Product id",
                    required = true
            )
            @PathParam("id") Long id
    );

    @POST
    @Path("/products")
    @Operation(
            operationId = "addProduct",
            summary = "Add a new Product",
            description = "Add a new product to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Product is added",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    Response addProduct(
            @RequestBody(
                    description = "Product to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProductDTO.class))
            )
            ProductDTO productDTO
    );

    @DELETE
    @Path("/products/{id}")
    @Operation(
            operationId = "deleteProduct",
            summary = "Delete an existing Product",
            description = "Delete a product inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Product is deleted",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    Response deleteProduct(
            @Parameter(
                    description = "Product id",
                    required = true
            )
            @PathParam("id") long id
    );

    @PUT
    @Path("/products/{id}")
    @Operation(
            operationId = "updateProduct",
            summary = "Update an existing Product",
            description = "Update a product inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Product is updated",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    String updateProduct(
            @Parameter(
                    description = "Product id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Product",
                    required = true
            )
            ProductDTO productDTO
    );

    @POST
    @Path("/products/addOneHundred")
    @Operation(
            operationId = "addOneHundredProduct",
            summary = "Add a new one hundred products",
            description = "Add a new one hundred products to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "One hundred products is added",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = ProductDTO.class)
            )
    )
    Response addOneHundredProduct(
            @RequestBody(
                    description = "Product to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProductDTO.class))
            )
            ProductDTO productDTO
    );
}
