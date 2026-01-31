package com.HyperLocal_Inventory.Loaction_Service.controllers;

import com.HyperLocal_Inventory.Loaction_Service.DTOs.*;
import com.HyperLocal_Inventory.Loaction_Service.services.LocationEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@Tag(name = "1. Location_CRU APIs" ,description = "Authenticated APIs for All User For Create , Read , Update operations Of Location ")
public class LocationEntryController {

    private static final Logger log = LoggerFactory.getLogger(LocationEntryController.class);
    private final LocationEntryService locationEntryService;

    public LocationEntryController(LocationEntryService locationEntryService) {
        this.locationEntryService = locationEntryService;
    }

    @GetMapping
    public ResponseEntity<List<EntryResponseDTO>> getAll(){
        return ResponseEntity.ok().body(locationEntryService.getAll());
    }


    @PostMapping
    public ResponseEntity<EntryResponseDTO> newLocationEntry(@RequestHeader("LoggedInUserId") String userId,@RequestBody EntryRequestDTO newEntry){
        log.info(userId);
        EntryResponseDTO saved = locationEntryService.saveLocation(userId , newEntry);
        return ResponseEntity.ok().body(saved);
    }

    @PutMapping
    public ResponseEntity<UpdateResponseDTO> toUpdate(@RequestHeader("LoggedInUserId") String userId, @RequestBody UpdateRequestDTO updateLocation){
        UpdateResponseDTO updated = locationEntryService.updateLocation(userId, updateLocation);
        return ResponseEntity.ok().body(updated);
    }

}
