package com.example.thegarage.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import com.example.thegarage.model.Vehicle;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class VehicleRepository {
    protected HashMap<String, Vehicle> vehicles = new HashMap<String, Vehicle>();

    public Vehicle findById(String id) {
        return this.vehicles.get(id);
    }

    public void insert(Vehicle vehicle) {
        this.vehicles.put(vehicle.getId(), vehicle);
    }

    public Collection<Vehicle> list() {
        return this.vehicles.values();
    }
}
