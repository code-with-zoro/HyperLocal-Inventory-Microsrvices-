package com.Hyperlocal_Inventory.API_Gateway.exceptions;

public class UnAuthorizeAccessException extends RuntimeException{

    public UnAuthorizeAccessException(String message){
        super(message);
    }
}
