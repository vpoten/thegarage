package com.example.thegarage.model;

import com.example.thegarage.entity.VehicleType;

public class VehicleInput {
    private String id;
    private VehicleType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
