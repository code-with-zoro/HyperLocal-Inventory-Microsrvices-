package com.Hyperlocal_Inventory.API_Gateway.exceptions;

public class MissingAuthorizarionHeader extends RuntimeException{
    public MissingAuthorizarionHeader(String message){
        super(message);
    }
}
