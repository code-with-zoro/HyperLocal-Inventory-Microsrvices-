package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SellingRequestDTO {
    @NotBlank(message = "Enter Your preferred vendorId Id")
    private String VendorId;

    @NotBlank(message = "Enter Product Name")
    @Size(max = 100,message = "Product Name Cannot Exceed 100 Char")
    private String productName;

    @NotNull(message = "Enter Quantity")
    private Integer demandQuantity;

    public @NotBlank(message = "Enter Your preferred vendorId Id") String getVendorId() {
        return VendorId;
    }

    public void setVendorId(@NotBlank(message = "Enter Your preferred vendorId Id") String vendorId) {
        VendorId = vendorId;
    }

    public @NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String productName) {
        this.productName = productName;
    }

    public @NotNull(message = "Enter Quantity") Integer getDemandQuantity() {
        return demandQuantity;
    }

    public void setDemandQuantity(@NotNull(message = "Enter Quantity") Integer demandQuantity) {
        this.demandQuantity = demandQuantity;
    }
}
