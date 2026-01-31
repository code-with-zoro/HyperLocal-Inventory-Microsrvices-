package com.HyperLocal_Inventory.User_Auth_Service.controllers;

import com.HyperLocal_Inventory.User_Auth_Service.external.aggregation.InventoryAggregationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@Tag(name = "4. Role Based APIs - Vendor" , description = " Authenticated APIs For Vendors only , To Read His Inventory Details")
public class VendorControler {

    private final InventoryAggregationService inventoryAggregationService;

    public VendorControler(InventoryAggregationService inventoryAggregationService) {
        this.inventoryAggregationService = inventoryAggregationService;
    }

    @GetMapping
    public ResponseEntity<?> getProducts(@RequestHeader("LoggedInUserId") String vendorId){
        return ResponseEntity.ok().body(inventoryAggregationService.vendorProducts(vendorId));
    }
}
