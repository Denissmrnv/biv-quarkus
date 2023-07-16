package edu.my.controller;

import edu.my.api.CharacteristicAPI;
import edu.my.dto.characteristic.CharacteristicDTO;
import edu.my.service.characteristic.CharacteristicControllerService;
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
@Path("/")
public class CharacteristicController implements CharacteristicAPI {
    @Inject
    CharacteristicControllerService characteristicControllerService;

    @GET
    @Path("/characteristics")
    @Counted(name = "performedChecksGetAllCharacteristics", description = "How many requests of all characteristics were made.")
    @Timed(name = "checksTimerGetAllCharacteristics", description = "A measure of how long it takes to complete a query of all characteristics.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getAllCharacteristics()  {
        return Response.ok(characteristicControllerService.getAllCharacteristics()).build();
    }

    @GET
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksGetOneCharacteristic", description = "How many requests of one characteristic were made.")
    @Timed(name = "checksTimerGetOneCharacteristic", description = "A measure of how long it takes to complete a query of one characteristic.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response getCharacteristicById(@PathParam("id") Long id)  {
        return Response.ok(characteristicControllerService.getCharacteristic(id)).build();
    }

    @POST
    @Path("/characteristics")
    @Counted(name = "performedChecksAddCharacteristic", description = "How many characteristic additions have been made.")
    @Timed(name = "checksTimerAddCharacteristic", description = "A measure of how long it takes to complete a characteristic addition.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response addCharacteristic(CharacteristicDTO characteristicDTO) {
        characteristicControllerService.saveCharacteristic(characteristicDTO);
        return Response.status(Response.Status.CREATED).entity(characteristicControllerService.getAllCharacteristics()).build();
    }

    @DELETE
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksDeleteCharacteristic", description = "How many characteristic deleted have been made.")
    @Timed(name = "checksTimerDeleteCharacteristic", description = "A measure of how long it takes to complete a characteristic delete.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response deleteCharacteristic(@PathParam("id") long id) {
        characteristicControllerService.deleteCharacteristic(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksUpdateCharacteristic", description = "How many characteristic updated have been made.")
    @Timed(name = "checksTimerUpdateCharacteristic", description = "A measure of how long it takes to complete a characteristic update.", unit = MetricUnits.MILLISECONDS)
    @Override
    public Response updateCharacteristic(@PathParam("id") long id, CharacteristicDTO characteristicDTO) {
        characteristicControllerService.updateCharacteristic(id, characteristicDTO);
        return Response.ok(characteristicControllerService.getAllCharacteristics()).build();
    }
}
