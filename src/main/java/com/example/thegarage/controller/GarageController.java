package com.example.thegarage.controller;


import com.example.thegarage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.thegarage.entity.Garage;
import com.example.thegarage.model.GarageInput;

@RestController
@RequestMapping("/api/garage")
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping(value = "/{id}")
    public Garage findById(@PathVariable("id") Long id) {
        return garageService.getGarage(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Garage create(@RequestBody GarageInput data) {
        return garageService.addGarage(data);
    }

}
