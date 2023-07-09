package edu.my.controller;
import edu.my.dto.CharacteristicDTO;
import edu.my.entity.Characteristic;
import edu.my.service.CharacteristicService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public List<CharacteristicDTO> getAllCharacteristics()  {
        return characteristicService.getAllCharacteristics();
    }

    @GET
    @Path("/characteristics/{id}")
    public CharacteristicDTO getCharacteristicById(@PathParam("id") Long id)  {
        return characteristicService.getCharacteristic(id);
    }

    @POST
    @Path("/characteristics")
    public String addCharacteristic(CharacteristicDTO characteristicDTO) {
        characteristicService.saveCharacteristic(characteristicDTO);
        return "Characteristic is added";
    }

    @DELETE
    @Path("/characteristics/{id}")
    public String deleteCharacteristic(@PathParam("id") long id) {
        characteristicService.deleteCharacteristic(id);
        return "Characteristic is deleted";
    }

    @PUT
    @Path("/characteristics/{id}")
    public String updateCharacteristic(@PathParam("id") long id, CharacteristicDTO characteristicDTO) {
        characteristicService.updateCharacteristic(id, characteristicDTO);
        return "Characteristic is updated";
    }
}
