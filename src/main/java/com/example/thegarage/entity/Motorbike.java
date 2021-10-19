package com.example.thegarage.entity;


public class Motorbike extends Vehicle {
    public Motorbike(String id) {
        super(id);
        this.setType(VehicleType.MOTORBIKE);
    }
}
