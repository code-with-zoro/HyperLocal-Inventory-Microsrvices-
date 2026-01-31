package com.HyperLocal_Inventory.User_Auth_Service.DTOs;

import com.HyperLocal_Inventory.User_Auth_Service.enums.Roles;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;

import java.awt.*;

public class UpdateResponseDTO {

    private String userName;

    private String email;

    private String password;

   /* private Roles roles;

    private Point location;*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public Roles getRoles() {
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
    }*/
}
