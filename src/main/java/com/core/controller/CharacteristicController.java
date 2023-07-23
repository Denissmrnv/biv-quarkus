package com.core.controller;

import com.api.api.CharacteristicAPI;
import com.api.dto.characteristic.CharacteristicRequestDTO;
import com.core.service.characteristic.CharacteristicControllerService;
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
public class CharacteristicController implements CharacteristicAPI {
    @Inject
    CharacteristicControllerService characteristicControllerService;

    @Counted(name = "performedChecksGetAllCharacteristics", description = "How many requests of all characteristics were made.")
    @Timed(name = "checksTimerGetAllCharacteristics", description = "A measure of how long it takes to complete a query of all characteristics.", unit = MetricUnits.MILLISECONDS)
    public Response getAllCharacteristics()  {
        return Response.ok(characteristicControllerService.getAllCharacteristics()).build();
    }

    @Counted(name = "performedChecksGetOneCharacteristic", description = "How many requests of one characteristic were made.")
    @Timed(name = "checksTimerGetOneCharacteristic", description = "A measure of how long it takes to complete a query of one characteristic.", unit = MetricUnits.MILLISECONDS)
    public Response getCharacteristicById(@PathParam("id") Long id)  {
        return Response.ok(characteristicControllerService.getCharacteristic(id)).build();
    }

    @Counted(name = "performedChecksAddCharacteristic", description = "How many characteristic additions have been made.")
    @Timed(name = "checksTimerAddCharacteristic", description = "A measure of how long it takes to complete a characteristic addition.", unit = MetricUnits.MILLISECONDS)
    public Response addCharacteristic(CharacteristicRequestDTO characteristicRequestDTO) {
        characteristicControllerService.saveCharacteristic(characteristicRequestDTO);
        return Response.noContent().build();
    }

    @Counted(name = "performedChecksDeleteCharacteristic", description = "How many characteristic deleted have been made.")
    @Timed(name = "checksTimerDeleteCharacteristic", description = "A measure of how long it takes to complete a characteristic delete.", unit = MetricUnits.MILLISECONDS)
    public Response deleteCharacteristic(@PathParam("id") long id) {
        characteristicControllerService.deleteCharacteristic(id);
        return Response.noContent().build();
    }

    @Counted(name = "performedChecksUpdateCharacteristic", description = "How many characteristic updated have been made.")
    @Timed(name = "checksTimerUpdateCharacteristic", description = "A measure of how long it takes to complete a characteristic update.", unit = MetricUnits.MILLISECONDS)
    public Response updateCharacteristic(@PathParam("id") long id, CharacteristicRequestDTO characteristicRequestDTO) {
        characteristicControllerService.updateCharacteristic(id, characteristicRequestDTO);
        return Response.noContent().build();
    }
}
