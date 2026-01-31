package com.HyperLocal_Inventory.Loaction_Service.DTOs;

import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

public class UpdateResponseDTO {


    private String userId;

    private Roles roles;

    private GeoJsonPoint Location;

    private LocalDateTime updateAt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public  Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public GeoJsonPoint getLocation() {
        return Location;
    }

    public void setLocation(GeoJsonPoint location) {
        Location = location;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
