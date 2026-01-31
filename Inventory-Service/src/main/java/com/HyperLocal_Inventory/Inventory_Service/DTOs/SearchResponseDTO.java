package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import java.util.List;

public class SearchResponseDTO {
    //private String UserId;
    private String productName;
    private List<AllVendorsHaveProduct> products;

    public SearchResponseDTO(/*String userId*/ String productName, List<AllVendorsHaveProduct> products) {
        //this.UserId = userId;
        this.productName = productName;
        this.products = products;
    }

    /*public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }*/

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<AllVendorsHaveProduct> getProduct() {
        return products;
    }

    public void setProduct(List<AllVendorsHaveProduct> product) {
        this.products = product;
    }

}
