package com.example.thegarage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.thegarage.model.Vehicle;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @GetMapping(value = "/{id}")
    public Vehicle findById(@PathVariable("id") String id) {
        // TODO
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Vehicle data) {
        // TODO
        return null;
    }
}
