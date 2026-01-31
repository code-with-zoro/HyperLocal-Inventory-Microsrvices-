package com.HyperLocal_Inventory.Search_Service.external.externalDTOs;


import com.HyperLocal_Inventory.Search_Service.enums.AvailabilityStatus;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.math.BigDecimal;

public class AllVendorsHaveProduct {

    private String vendorId;
    private String productName;
    private String description;
    private BigDecimal price;
    private AvailabilityStatus availabilityStatus;
    private GeoJsonPoint loaction;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

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

    public GeoJsonPoint getLoaction() {
        return loaction;
    }

    public void setLoaction(GeoJsonPoint loaction) {
        this.loaction = loaction;
    }
}
