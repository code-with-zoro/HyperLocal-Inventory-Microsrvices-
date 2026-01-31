package com.HyperLocal_Inventory.Search_Service.external.externalDTOs;

public class LocationSearchRequestDTO {

    private String userId;
    private Double radius;
    private int limit;

    public LocationSearchRequestDTO(String userId, Double radius, int limit) {
        this.userId = userId;
        this.radius = radius;
        this.limit = limit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
