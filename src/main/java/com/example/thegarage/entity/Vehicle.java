package com.example.thegarage.entity;


import com.example.thegarage.model.Location;

public class Vehicle {
    protected String id;  // the license plate id
    protected Location location = null;
    protected VehicleType type = null;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location locate() {
        return this.getLocation();
    }

    public void exit() {
        this.setLocation(null);
    }

    public VehicleType getType() {
        return type;
    }

    protected void setType(VehicleType type) {
        this.type = type;
    }
}
