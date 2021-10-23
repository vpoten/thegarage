package com.example.thegarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.thegarage.entity.Garage;
import com.example.thegarage.entity.Vehicle;
import com.example.thegarage.entity.VehicleFactory;
import com.example.thegarage.repository.GarageRepository;
import com.example.thegarage.repository.VehicleRepository;
import com.example.thegarage.model.Location;
import com.example.thegarage.model.GarageInput;
import com.example.thegarage.model.VehicleInput;
import com.example.thegarage.exception.NoSuchElementFoundException;
import com.example.thegarage.exception.LocationError;
import com.example.thegarage.model.GarageOutput;


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

    public Garage addGarage(GarageInput data) {
        Garage garage = new Garage(data.getId(), data.getLevels(), data.getSpacesPerLevel());
        this.garages.insert(garage);
        return garage;
    }

    public Vehicle addVehicle(VehicleInput data) {
        Vehicle vehicle = VehicleFactory.create(data);
        vehicles.insert(vehicle);
        return vehicle;
    }

    public Location enter(Long garageId, String vehicleId) {
        Garage garage = this.getGarage(garageId);
        Vehicle vehicle = this.getVehicle(vehicleId);

        Location currentLocation = vehicle.getLocation();

        if (currentLocation != null) {
            throw new LocationError("The vehicle is already in a garage");
        }

        Location location = garage.getFirstFreeLocation();

        if (location == null) {
            return null;
        }

        garage.assign(location, vehicle);
        vehicle.setLocation(location);
        return location;
    }

    public void exit(String vehicleId) {
        Vehicle vehicle = this.getVehicle(vehicleId);
        Location location = vehicle.getLocation();

        if (location == null) {
            throw new LocationError("The vehicle is not located in a garage");
        }

        Garage garage = this.getGarage(location.getGarageId());
        vehicle.exit();
        garage.free(location);
    }

    public GarageOutput toOutput(Garage garage) {
        return new GarageOutput(garage.getId(), garage.getLevels(), garage.getSpacesPerLevel(), garage.getTotalSpaces(),
                garage.getFreeSpaces());
    }
}
