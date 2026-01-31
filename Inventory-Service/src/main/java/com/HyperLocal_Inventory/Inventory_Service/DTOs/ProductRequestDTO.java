package com.HyperLocal_Inventory.Inventory_Service.DTOs;

import com.HyperLocal_Inventory.Inventory_Service.enums.AvailabilityStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductRequestDTO {

    @NotBlank(message = "Enter Your Id")
    private String vendorId;

    @NotBlank(message = "Enter Product Name")
    @Size(max = 100,message = "Product Name Cannot Exceed 100 Char")
    private String productName;

    @NotBlank(message = "About this Product")
    private String description;

    @NotNull(message = "Enter price")
    private BigDecimal price;

    @NotNull(message = "Enter Quantity")
    private Integer quantity;

    /*private AvailabilityStatus availabilityStatus;

    @NotNull(message = "Enter product creation Date")
    private LocalDateTime createdAt;

    @NotNull(message = "Enter Today's Date")
    private LocalDateTime updatedAt;
*/
    public @NotBlank(message = "Enter Your Id") String getVendorId() {
        return vendorId;
    }

    public void setVendorId(@NotBlank(message = "Enter Your Id") String vendorId) {
        this.vendorId = vendorId;
    }

    public @NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Enter Product Name") @Size(max = 100, message = "Product Name Cannot Exceed 100 Char") String productName) {
        this.productName = productName;
    }

    public @NotBlank(message = "About this Product") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "About this Product") String description) {
        this.description = description;
    }

    public @NotNull(message = "Enter price") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Enter price") BigDecimal price) {
        this.price = price;
    }

    public @NotNull(message = "Enter Quantity") Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull(message = "Enter Quantity") Integer quantity) {
        this.quantity = quantity;
    }

  /*  public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public @NotNull(message = "Enter product creation Date") LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NotNull(message = "Enter product creation Date") LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public @NotNull(message = "Enter Today's Date") LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(@NotNull(message = "Enter Today's Date") LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }*/
}
