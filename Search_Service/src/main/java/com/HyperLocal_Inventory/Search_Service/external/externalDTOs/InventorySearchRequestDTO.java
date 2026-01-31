package com.HyperLocal_Inventory.Search_Service.external.externalDTOs;

import java.util.List;

public class InventorySearchRequestDTO {

    private List<String> vendorIds;
    private String productName;
    private Integer quantity;

    public List<String> getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(List<String> vendorIds) {
        this.vendorIds = vendorIds;
    }

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
