package com.example.thegarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.thegarage.model.Garage;
import com.example.thegarage.model.Vehicle;
import com.example.thegarage.repository.GarageRepository;
import com.example.thegarage.repository.VehicleRepository;
import com.example.thegarage.model.Location;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GarageService {
    @Autowired
    private GarageRepository garages;
    @Autowired
    private VehicleRepository vehicles;

    public Location enter(Long garageId, String vehicleId) {
        Garage garage = this.garages.findById(garageId);
        Vehicle vehicle = this.vehicles.findById(vehicleId);

        if (garage == null) {
            // TODO raise not found
        }
        if (vehicle == null) {
            // TODO raise not found
        }

        return garage.assign(vehicle);
    }

    public void exit(String vehicleId) {
        Vehicle vehicle = this.vehicles.findById(vehicleId);
        if (vehicle == null) {
            // TODO raise not found
        }
        vehicle.exit();
    }

    public Location locate(String vehicleId) {
        Vehicle vehicle = this.vehicles.findById(vehicleId);
        if (vehicle == null) {
            // TODO raise not found
        }
        return vehicle.locate();
    }
}
