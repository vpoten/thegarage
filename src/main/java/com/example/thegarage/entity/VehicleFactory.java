package com.example.thegarage.entity;

import com.example.thegarage.model.VehicleInput;

public class VehicleFactory {
    static public Vehicle create(VehicleInput data) {
        Vehicle vehicle = null;

        if (data.getType() == VehicleType.CAR) {
            vehicle = new Car(data.getId());
        } else if (data.getType() == VehicleType.MOTORBIKE) {
            vehicle = new Motorbike(data.getId());
        }

        return vehicle;
    }
}
