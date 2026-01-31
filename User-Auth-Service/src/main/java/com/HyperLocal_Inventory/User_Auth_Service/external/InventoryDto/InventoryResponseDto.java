package com.HyperLocal_Inventory.User_Auth_Service.external.InventoryDto;

import java.util.List;

public class InventoryResponseDto {
    private String vendorId;
    private String vendorName;
    private List<AllProductOfAVendor> allProducts;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public List<AllProductOfAVendor> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<AllProductOfAVendor> allProducts) {
        this.allProducts = allProducts;
    }
}
