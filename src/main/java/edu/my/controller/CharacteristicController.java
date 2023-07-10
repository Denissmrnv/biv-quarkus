package edu.my.controller;

import edu.my.dto.CategoryDTO;
import edu.my.dto.CharacteristicDTO;
import edu.my.service.CharacteristicService;
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
@Tag(name = "Characteristic Resource", description = "Characteristic REST APIs")
public class CharacteristicController {
    @Inject
    CharacteristicService characteristicService;

    @GET
    @Path("/characteristics")
    @Counted(name = "performedChecksGetAllCharacteristics", description = "How many requests of all characteristics were made.")
    @Timed(name = "checksTimerGetAllCharacteristics", description = "A measure of how long it takes to complete a query of all characteristics.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getAllCharacteristics",
            summary = "Get all Characteristics",
            description = "Get all characteristics inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getAllCharacteristics()  {
        return Response.ok(characteristicService.getAllCharacteristics()).build();
    }

    @GET
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksGetOneCharacteristic", description = "How many requests of one characteristic were made.")
    @Timed(name = "checksTimerGetOneCharacteristic", description = "A measure of how long it takes to complete a query of one characteristic.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "getCharacteristicById",
            summary = "Get Characteristic by id",
            description = "Get one characteristic inside the db"
    )
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response getCharacteristicById(@PathParam("id") Long id)  {
        return Response.ok(characteristicService.getCharacteristic(id)).build();
    }

    @POST
    @Path("/characteristics")
    @Counted(name = "performedChecksAddCharacteristic", description = "How many characteristic additions have been made.")
    @Timed(name = "checksTimerAddCharacteristic", description = "A measure of how long it takes to complete a characteristic addition.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "addCharacteristic",
            summary = "Add a new Characteristic",
            description = "Add a new characteristic to the db"
    )
    @APIResponse(
            responseCode = "201",
            description = "Characteristic is added",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response addCharacteristic(
            @RequestBody(
                    description = "Characteristic to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CharacteristicDTO.class))
            )
            CharacteristicDTO characteristicDTO) {
        characteristicService.saveCharacteristic(characteristicDTO);
        return Response.status(Response.Status.CREATED).entity(characteristicService.getAllCharacteristics()).build();

    }

    @DELETE
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksDeleteCharacteristic", description = "How many characteristic deleted have been made.")
    @Timed(name = "checksTimerDeleteCharacteristic", description = "A measure of how long it takes to complete a characteristic delete.", unit = MetricUnits.MILLISECONDS)
    @Operation(
            operationId = "deleteCharacteristic",
            summary = "Delete an existing Characteristic",
            description = "Delete a Characteristic inside the db"
    )
    @APIResponse(
            responseCode = "204",
            description = "Characteristic is deleted",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response deleteCharacteristic(@PathParam("id") long id) {
        characteristicService.deleteCharacteristic(id);
        return Response.noContent().build();
    }

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
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response updateCharacteristic(
            @Parameter(
                    description = "Characteristic id",
                    required = true
            )
            @PathParam("id") long id,
            @Parameter(
                    description = "Updated Characteristic",
                    required = true
            )
            CharacteristicDTO characteristicDTO) {
        characteristicService.updateCharacteristic(id, characteristicDTO);
        return Response.ok(characteristicService.getAllCharacteristics()).build();
    }
}
