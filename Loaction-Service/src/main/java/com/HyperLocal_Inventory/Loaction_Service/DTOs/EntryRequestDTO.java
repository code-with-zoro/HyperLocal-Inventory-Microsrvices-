package com.HyperLocal_Inventory.Loaction_Service.DTOs;

import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.management.relation.Role;
import java.awt.*;

public class EntryRequestDTO {

    /*@Indexed(unique = true)
    private String userId;*/


    @NotNull(message = "Enter yor Role :- USER || VENDOR" )
    private Roles roles;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

   /* public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }*/

    public @NotNull(message = "Enter yor Role :- USER || VENDOR") Roles getRoles() {
        return roles;
    }

    public void setRoles(@NotNull(message = "Enter yor Role :- USER || VENDOR") Roles roles) {
        this.roles = roles;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }
}
