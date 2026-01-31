package com.HyperLocal_Inventory.User_Auth_Service.external.InventoryDto;

import com.HyperLocal_Inventory.User_Auth_Service.enums.AvailabilityStatus;

import java.math.BigDecimal;

public class AllProductOfAVendor {

    private String productName;
    private String description;
    private BigDecimal price;
    private AvailabilityStatus availabilityStatus;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
