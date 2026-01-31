package com.HyperLocal_Inventory.User_Auth_Service.DTOs;

import com.HyperLocal_Inventory.User_Auth_Service.enums.Roles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;

import java.awt.*;

public class UserRequestDTO {

    @NotBlank(message = "Enter Your Name")
    @Size(max = 100 , message = "Name Cannot Exceed 100 Charatcters")
    private String userName;


    @NotBlank(message = "Enter Your Email")
    private String email;

    @NotBlank(message = "Enter your Password")
    private String password;


    private Roles roles;


    private Point location;

    //Getters And Setters


    public @NotBlank(message = "Enter Your Name") @Size(max = 100, message = "Name Cannot Exceed 100 Charatcters") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "Enter Your Name") @Size(max = 100, message = "Name Cannot Exceed 100 Charatcters") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "Enter Your Email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Enter Your Email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Enter your Password") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Enter your Password") String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
