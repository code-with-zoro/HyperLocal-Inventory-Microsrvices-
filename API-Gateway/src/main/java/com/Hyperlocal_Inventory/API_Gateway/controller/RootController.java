package com.Hyperlocal_Inventory.API_Gateway.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
@Tag(name = "1. Home")
public class RootController {

    @GetMapping
    public ResponseEntity<?> HomePage(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
