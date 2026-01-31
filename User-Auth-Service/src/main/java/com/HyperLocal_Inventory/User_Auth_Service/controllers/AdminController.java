package com.HyperLocal_Inventory.User_Auth_Service.controllers;

import com.HyperLocal_Inventory.User_Auth_Service.DTOs.AdminResponseDTO;
import com.HyperLocal_Inventory.User_Auth_Service.services.UserEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "3. Role Based APIs - Admin" , description = " Authenticated API For Admin , Only to Read All Users Non Confidential Details And Server Health Check")
public class AdminController {

    private final UserEntryService userEntryService;

    public AdminController(UserEntryService userEntryService) {
        this.userEntryService = userEntryService;
    }

    @GetMapping("/Health-Check")
    public String healthCheck(){
        return "OK";
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<AdminResponseDTO> all = userEntryService.getAllUsers();
            return ResponseEntity.ok(all);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
