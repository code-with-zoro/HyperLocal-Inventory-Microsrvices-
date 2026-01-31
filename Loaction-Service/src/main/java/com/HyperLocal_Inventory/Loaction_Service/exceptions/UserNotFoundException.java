package com.HyperLocal_Inventory.Loaction_Service.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (String message){
        super(message);
    }
}
