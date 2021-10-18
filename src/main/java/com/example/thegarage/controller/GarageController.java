package com.example.thegarage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.thegarage.model.Garage;

@RestController
@RequestMapping("/api/garage")
public class GarageController {

    @GetMapping(value = "/{id}")
    public Garage findById(@PathVariable("id") Long id) {
        // TODO
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Garage data) {
        // TODO
        return null;
    }

}
