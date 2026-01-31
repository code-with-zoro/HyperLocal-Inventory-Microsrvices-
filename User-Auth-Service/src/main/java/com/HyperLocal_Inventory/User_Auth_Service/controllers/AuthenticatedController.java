package com.HyperLocal_Inventory.User_Auth_Service.controllers;

import com.HyperLocal_Inventory.User_Auth_Service.DTOs.DeleteResponseDTO;
import com.HyperLocal_Inventory.User_Auth_Service.DTOs.UpdateResponseDTO;
import com.HyperLocal_Inventory.User_Auth_Service.DTOs.UserRequestDTO;
import com.HyperLocal_Inventory.User_Auth_Service.services.UserEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "2. Authenticated APIs" , description = " Authenticated APIs For User to Update Update Details and Delete User")
public class AuthenticatedController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticatedController.class);
    private final UserEntryService userEntryService;

    public AuthenticatedController(UserEntryService userEntryService) {
        this.userEntryService = userEntryService;
    }


    @PutMapping()
    public ResponseEntity<UpdateResponseDTO> updateUser(
            @RequestHeader("LoggedInUserId") String myId,
            @RequestBody UserRequestDTO user)
    {
        UpdateResponseDTO upadted = userEntryService.updateUser(myId, user);
        return ResponseEntity.ok(upadted);
    }

    @DeleteMapping()
    public ResponseEntity<DeleteResponseDTO> deleteUser(@RequestHeader("LoggedInUserId") String myId){
        DeleteResponseDTO deletedUser = userEntryService.deleteUser(myId);
        log.info("deleted: "+deletedUser.getUserName());
        return ResponseEntity.ok(deletedUser);
    }
}
