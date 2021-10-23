package com.example.thegarage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.thegarage.service.GarageService;
import com.example.thegarage.entity.Vehicle;
import com.example.thegarage.model.VehicleInput;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    private GarageService garageService;

    @GetMapping(value = "/{id}")
    public Vehicle findById(@PathVariable("id") String id) {
        return garageService.getVehicle(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle create(@RequestBody VehicleInput data) {
        return garageService.addVehicle(data);
    }

    @PostMapping(value = "/{id}/exit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exit(@PathVariable("id") String id) {
        garageService.exit(id);
    }
}
