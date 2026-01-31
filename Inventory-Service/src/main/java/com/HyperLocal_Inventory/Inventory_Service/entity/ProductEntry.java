package com.HyperLocal_Inventory.Inventory_Service.entity;

import com.HyperLocal_Inventory.Inventory_Service.enums.AvailabilityStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "products")
@CompoundIndex(
        name = "vendor_product_unique",
        def = "{'vendorId': 1, 'productName': 1}",
        unique = true
)//this index define that same vendor cant have multiple products of same name instad of makin product name unique kyu ki fir dusra vendor ke pass same product nhi hosakta tha iss liye compund index its like & operator
public class ProductEntry {

    @Id
    private ObjectId productId;

    private String vendorId;

    private String productName;
    private String description;

    private BigDecimal price;
    private Integer quantity;

    private AvailabilityStatus availabilityStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ObjectId getProductId() {
        return productId;
    }

    public void setProductId(ObjectId productId) {
        this.productId = productId;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

