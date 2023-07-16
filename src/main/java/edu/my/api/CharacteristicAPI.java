package edu.my.api;

import edu.my.dto.characteristic.CharacteristicDTO;
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

@Path("/")
@Tag(name = "Characteristic Resource", description = "Characteristic REST APIs")
public interface CharacteristicAPI {
    @GET
    @Path("/characteristics")
    @Operation(
            operationId = "getAllCharacteristics",
            summary = "Get all Characteristics",
            description = "Get all characteristics inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CharacteristicDTO.class)
            )
    )
    Response getAllCharacteristics();

    @GET
    @Path("/characteristics/{id}")
    @Operation(
            operationId = "getCharacteristicById",
            summary = "Get Characteristic by id",
            description = "Get one characteristic inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CharacteristicDTO.class)
            )
    )
    Response getCharacteristicById(
            @Parameter(
                    description = "Characteristic id",
                    required = true
            )
            @PathParam("id") Long id
    );

    @POST
    @Path("/characteristics")
    @Operation(
            operationId = "addCharacteristic",
            summary = "Add a new Characteristic",
            description = "Add a new characteristic to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Characteristic is added",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CharacteristicDTO.class)
            )
    )
    Response addCharacteristic(
            @RequestBody(
                    description = "Characteristic to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CharacteristicDTO.class))
            )
            CharacteristicDTO characteristicDTO
    );

    @DELETE
    @Path("/characteristics/{id}")
    @Operation(
            operationId = "deleteCharacteristic",
            summary = "Delete an existing Characteristic",
            description = "Delete a Characteristic inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Characteristic is deleted",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CharacteristicDTO.class)
            )
    )
    Response deleteCharacteristic(
            @Parameter(
                    description = "Characteristic id",
                    required = true
            )
            @PathParam("id") long id
    );

    @PUT
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksUpdateCharacteristic", description = "How many characteristic updated have been made.")
    @Timed(name = "checksTimerUpdateCharacteristic", description = "A measure of how long it takes to complete a characteristic update.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "updateCharacteristic",
            summary = "Update an existing Characteristic",
            description = "Update a Characteristic inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Characteristic is updated",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = CharacteristicDTO.class)
            )
    )
    Response updateCharacteristic(
            @Parameter(
                    description = "Characteristic id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Characteristic",
                    required = true
            )
            CharacteristicDTO characteristicDTO
    );
}
