package edu.my.controller;
import edu.my.dto.CharacteristicDTO;
import edu.my.entity.Characteristic;
import edu.my.service.CharacteristicService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
public class CharacteristicController {
    @Inject
    CharacteristicService characteristicService;

    @GET
    @Path("/characteristics")
    @Counted(name = "performedChecksGetAllCharacteristics", description = "How many requests of all characteristics were made.")
    @Timed(name = "checksTimerGetAllCharacteristics", description = "A measure of how long it takes to complete a query of all characteristics.", unit = MetricUnits.MILLISECONDS)
    public List<CharacteristicDTO> getAllCharacteristics()  {
        return characteristicService.getAllCharacteristics();
    }

    @GET
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksGetOneCharacteristic", description = "How many requests of one characteristic were made.")
    @Timed(name = "checksTimerGetOneCharacteristic", description = "A measure of how long it takes to complete a query of one characteristic.", unit = MetricUnits.MILLISECONDS)
    public CharacteristicDTO getCharacteristicById(@PathParam("id") Long id)  {
        return characteristicService.getCharacteristic(id);
    }

    @POST
    @Path("/characteristics")
    @Counted(name = "performedChecksAddCharacteristic", description = "How many characteristic additions have been made.")
    @Timed(name = "checksTimerAddCharacteristic", description = "A measure of how long it takes to complete a characteristic addition.", unit = MetricUnits.MILLISECONDS)
    public String addCharacteristic(CharacteristicDTO characteristicDTO) {
        characteristicService.saveCharacteristic(characteristicDTO);
        return "Characteristic is added";
    }

    @DELETE
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksDeleteCharacteristic", description = "How many characteristic deleted have been made.")
    @Timed(name = "checksTimerDeleteCharacteristic", description = "A measure of how long it takes to complete a characteristic delete.", unit = MetricUnits.MILLISECONDS)
    public String deleteCharacteristic(@PathParam("id") long id) {
        characteristicService.deleteCharacteristic(id);
        return "Characteristic is deleted";
    }

    @PUT
    @Path("/characteristics/{id}")
    @Counted(name = "performedChecksUpdateCharacteristic", description = "How many characteristic updated have been made.")
    @Timed(name = "checksTimerUpdateCharacteristic", description = "A measure of how long it takes to complete a characteristic update.", unit = MetricUnits.MILLISECONDS)
    public String updateCharacteristic(@PathParam("id") long id, CharacteristicDTO characteristicDTO) {
        characteristicService.updateCharacteristic(id, characteristicDTO);
        return "Characteristic is updated";
    }
}
