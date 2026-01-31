package com.HyperLocal_Inventory.User_Auth_Service.DTOs;

import com.HyperLocal_Inventory.User_Auth_Service.enums.Roles;

public class SignupResponseDTO {
    private String userName;
    private String email;
    private Roles role;

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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
