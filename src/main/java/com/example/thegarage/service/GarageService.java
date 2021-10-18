package com.example.thegarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.thegarage.model.Garage;
import com.example.thegarage.model.Vehicle;
import com.example.thegarage.repository.GarageRepository;
import com.example.thegarage.repository.VehicleRepository;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GarageService {
    @Autowired
    private GarageRepository garages;
    @Autowired
    private VehicleRepository vehicles;

    public void enter(Garage garage, Vehicle vehicle) {
        // TODO
    }

    public void exit(Vehicle vehicle) {
        // TODO
    }

    public void locate(Vehicle vehicle) {
        // TODO
    }
}
