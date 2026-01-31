package com.HyperLocal_Inventory.Loaction_Service.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException (String Message){
        super(Message);
    }
}
