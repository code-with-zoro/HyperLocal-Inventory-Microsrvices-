package com.HyperLocal_Inventory.Inventory_Service.exceptions;

public class SellingQuantityMustBePositive extends RuntimeException{
    public SellingQuantityMustBePositive(String message){
        super(message);
    }
}
