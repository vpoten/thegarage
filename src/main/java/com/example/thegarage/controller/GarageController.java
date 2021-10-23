package com.example.thegarage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.thegarage.service.GarageService;
import com.example.thegarage.model.GarageInput;
import com.example.thegarage.model.Location;
import com.example.thegarage.model.GarageOutput;

@RestController
@RequestMapping("/api/garage")
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping(value = "/{id}")
    public GarageOutput findById(@PathVariable("id") Long id) {
        return garageService.toOutput(garageService.getGarage(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GarageOutput create(@RequestBody GarageInput data) {
        return garageService.toOutput(garageService.addGarage(data));
    }

    @PostMapping(value = "/{garageId}/enter/{vehicleId}")
    public Location enter(@PathVariable("garageId") Long garageId, @PathVariable("vehicleId") String vehicleId) {
        return garageService.enter(garageId, vehicleId);
    }

}
