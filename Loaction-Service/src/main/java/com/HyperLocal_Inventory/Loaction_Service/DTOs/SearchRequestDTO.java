package com.HyperLocal_Inventory.Loaction_Service.DTOs;

import com.HyperLocal_Inventory.Loaction_Service.enums.Roles;

public class SearchRequestDTO {

    private String userId;
    private Double radius;
    private int limit;

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
