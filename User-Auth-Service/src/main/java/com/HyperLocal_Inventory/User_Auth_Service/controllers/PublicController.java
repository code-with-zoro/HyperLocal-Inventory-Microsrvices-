package com.HyperLocal_Inventory.User_Auth_Service.controllers;

import com.HyperLocal_Inventory.User_Auth_Service.DTOs.SignupResponseDTO;
import com.HyperLocal_Inventory.User_Auth_Service.DTOs.UserRequestDTO;
import com.HyperLocal_Inventory.User_Auth_Service.entity.UserEntry;
import com.HyperLocal_Inventory.User_Auth_Service.repository.UserEntryRepository;
import com.HyperLocal_Inventory.User_Auth_Service.services.UserEntryService;
import com.HyperLocal_Inventory.User_Auth_Service.utils.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Tag(name = "1. Public APIs" , description = " Non Authenticated APIs For User to Signup and Login")
public class PublicController {

    private final UserEntryService userEntryService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final UserEntryRepository userEntryRepository;
    private final JwtUtil jwt;

    public PublicController(UserEntryService userEntryService, UserDetailsService userDetailsService, AuthenticationManager authenticationManager, UserEntryRepository userEntryRepository, JwtUtil jwt) {
        this.userEntryService = userEntryService;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.userEntryRepository = userEntryRepository;
        this.jwt = jwt;
    }

    //signup
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody UserRequestDTO userRequestDTO) {
           SignupResponseDTO newUser = userEntryService.saveUser(userRequestDTO);
            return ResponseEntity.ok(newUser);
    }
    //login
    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody UserRequestDTO user){
        try{
           authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
            UserEntry me = userEntryRepository.getByUserName(user.getUserName());
            String token =jwt.generateToken(String.valueOf(me.getId()));
            return new ResponseEntity<>(token, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }


}
