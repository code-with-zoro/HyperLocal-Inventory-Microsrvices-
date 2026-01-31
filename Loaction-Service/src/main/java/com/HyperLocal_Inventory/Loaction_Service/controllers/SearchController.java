package com.HyperLocal_Inventory.Loaction_Service.controllers;

import com.HyperLocal_Inventory.Loaction_Service.DTOs.SearchRequestDTO;
import com.HyperLocal_Inventory.Loaction_Service.DTOs.SearchResponseDTO;
import com.HyperLocal_Inventory.Loaction_Service.services.LocationEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/searchLocation")
@Tag(name = "2. Search APIs" ,description = "APIs for Inter-Service Call's")
public class SearchController {

    private final LocationEntryService locationEntryService;

    public SearchController(LocationEntryService locationEntryService) {
        this.locationEntryService = locationEntryService;
    }

    @PostMapping
    public ResponseEntity<SearchResponseDTO> allVendorNearUser(@RequestBody SearchRequestDTO search){
        return ResponseEntity.ok().body(locationEntryService.searchResult(search));
    }
}
