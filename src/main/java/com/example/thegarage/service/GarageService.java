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
import com.example.thegarage.exception.NoSuchElementFoundException;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GarageService {
    @Autowired
    private GarageRepository garages;
    @Autowired
    private VehicleRepository vehicles;

    public Garage getGarage(Long id) {
        Garage garage = this.garages.findById(id);
        if (garage == null) {
            throw new NoSuchElementFoundException("Garage with id " + id + " not found");
        }
        return garage;
    }

    public Vehicle getVehicle(String id) {
        Vehicle vehicle = this.vehicles.findById(id);
        if (vehicle == null) {
            throw new NoSuchElementFoundException("Vehicle with id " + id + " not found");
        }
        return vehicle;
    }

    public Location enter(Long garageId, String vehicleId) {
        Garage garage = this.getGarage(garageId);
        Vehicle vehicle = this.getVehicle(vehicleId);
        return garage.assign(vehicle);
    }

    public void exit(String vehicleId) {
        Vehicle vehicle = this.getVehicle(vehicleId);
        vehicle.exit();
    }

    public Location locate(String vehicleId) {
        Vehicle vehicle = this.getVehicle(vehicleId);
        return vehicle.locate();
    }
}
