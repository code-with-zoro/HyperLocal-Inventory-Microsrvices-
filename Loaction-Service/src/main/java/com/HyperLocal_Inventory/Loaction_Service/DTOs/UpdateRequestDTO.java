package com.HyperLocal_Inventory.Loaction_Service.DTOs;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;


public class UpdateRequestDTO {

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint locationToUpdate;

    public GeoJsonPoint getLocationToUpdate() {
        return locationToUpdate;
    }

    public void setLocationToUpdate(GeoJsonPoint locationToUpdate) {
        this.locationToUpdate = locationToUpdate;
    }
}
