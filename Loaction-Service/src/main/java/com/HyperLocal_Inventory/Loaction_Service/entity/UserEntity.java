package com.HyperLocal_Inventory.Loaction_Service.entity;

import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.relation.Role;
import java.awt.*;
import java.time.LocalDateTime;

@Document(collection = "locationsTree")
public class UserEntity {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String userId;


    @NotNull(message = "Enter yor Role :- USER || VENDOR" )
    private Roles roles;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public @NotNull(message = "Enter yor Role :- USER || VENDOR") Roles getRoles() {
        return roles;
    }

    public void setRoles(@NotNull(message = "Enter yor Role :- USER || VENDOR") Roles roles) {
        this.roles = roles;
    }

    public GeoJsonPoint getlocation() {
        return location;
    }

    public void setlocation(GeoJsonPoint location) {
        this.location = location;
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
