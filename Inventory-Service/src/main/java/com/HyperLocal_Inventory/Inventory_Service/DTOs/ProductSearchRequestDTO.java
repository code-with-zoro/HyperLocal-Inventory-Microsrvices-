package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductSearchRequestDTO {


    @NotBlank(message = "Enter Product Name")
    @Size(max = 100,message = "Product Name Cannot Exceed 100 Char")
    private String productName;

    public @NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String productName) {
        this.productName = productName;
    }
}
