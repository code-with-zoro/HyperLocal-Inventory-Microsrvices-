package com.HyperLocal_Inventory.Search_Service.DTOs;

import com.HyperLocal_Inventory.Search_Service.external.externalDTOs.AllVendorsHaveProduct;

import java.util.List;

public class UserSearchResultDTO {

    private String productName;
    private String message;
    private List<AllVendorsHaveProduct> products;

    public UserSearchResultDTO(){}
    public UserSearchResultDTO(String productName,String message, List<AllVendorsHaveProduct> products) {
        this.productName = productName;
        this.message= message;
        this.products = products;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AllVendorsHaveProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AllVendorsHaveProduct> products) {
        this.products = products;
    }
}
