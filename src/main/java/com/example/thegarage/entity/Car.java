package com.example.thegarage.entity;


public class Car extends Vehicle {
    public Car(String id) {
        super(id);
        this.setType(VehicleType.CAR);
    }
}
