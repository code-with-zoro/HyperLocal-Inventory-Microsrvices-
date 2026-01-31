package com.HyperLocal_Inventory.Search_Service.DTOs;

public class UserSearchDTO {


    private String productName;
    private Integer quantity;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
