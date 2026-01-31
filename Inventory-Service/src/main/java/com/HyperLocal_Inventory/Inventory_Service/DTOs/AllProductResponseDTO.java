package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import java.util.List;

public class AllProductResponseDTO {
    private String vendorId;
    private List<AllProductOfAVendor> allProducts;

    public AllProductResponseDTO(String vendorId, List<AllProductOfAVendor> allProducts) {
        this.vendorId = vendorId;
        this.allProducts = allProducts;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public List<AllProductOfAVendor> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<AllProductOfAVendor> allProducts) {
        this.allProducts = allProducts;
    }
}
