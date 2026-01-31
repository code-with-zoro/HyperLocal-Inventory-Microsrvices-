package com.HyperLocal_Inventory.Inventory_Service.controllers;

import com.HyperLocal_Inventory.Inventory_Service.DTOs.*;
import com.HyperLocal_Inventory.Inventory_Service.entity.ProductEntry;
import com.HyperLocal_Inventory.Inventory_Service.service.ProductEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "1. Product_CRUD APIs" ,description = "Authenticated APIs for Vendors Use Only For CRUD operations OF Product ")
public class ProductEntryController {

    private final ProductEntryService productEntryService;

    public ProductEntryController(ProductEntryService productEntryService) {
        this.productEntryService = productEntryService;
    }


    @GetMapping
    public ResponseEntity<AllProductResponseDTO> getAll(@RequestHeader("LoggedInUserId") String myId){
            AllProductResponseDTO allProducts = productEntryService.all(myId);
            return ResponseEntity.ok().body(allProducts);
        }

    @PostMapping
    public ResponseEntity<CreatedResponseDTO> saveNewProduct(
            @RequestHeader("LoggedInUserId") String vendorId ,
            @RequestBody ProductRequestDTO newProduct){ // vendorId productName description price quantity
      CreatedResponseDTO saved = productEntryService.createNewProduct(vendorId ,newProduct);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping
    public ResponseEntity<UpdateResponseDTO> updateProductDetails(@RequestHeader("LoggedInUserId") String myId, @RequestBody ProductRequestDTO toUpdate){ // productId , vendorId productName description price quantity
        UpdateResponseDTO updated = productEntryService.updateProduct(myId,toUpdate);
        return ResponseEntity.ok().body(updated);
    }

}
