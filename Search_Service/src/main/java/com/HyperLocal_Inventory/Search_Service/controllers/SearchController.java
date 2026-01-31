package com.HyperLocal_Inventory.Search_Service.controllers;


import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchDTO;
import com.HyperLocal_Inventory.Search_Service.DTOs.UserSearchResultDTO;
import com.HyperLocal_Inventory.Search_Service.services.SearchServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/searchProduct")
@Tag(name = "1. Product_Search APIs" ,description = "Searches for products available near the user based on location."
                      +" The API finds nearby vendors within a defined radius and returns."
                   +" products that match the search criteria, ensuring hyper-local availability")
public class SearchController {

    private final SearchServices services;

    public SearchController(SearchServices services) {
        this.services = services;
    }


    @PostMapping
    public ResponseEntity<UserSearchResultDTO> userSearch(@RequestHeader("LoggedInUserId") String myId
            , @RequestBody UserSearchDTO search){
        return ResponseEntity.ok().body(services.searchResult(myId,search));
    }
}
