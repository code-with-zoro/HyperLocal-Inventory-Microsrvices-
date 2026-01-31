package com.HyperLocal_Inventory.User_Auth_Service.exception;

public class UserDoNotExistsException extends RuntimeException{
    public UserDoNotExistsException (String message){
        super(message);
    }
}
