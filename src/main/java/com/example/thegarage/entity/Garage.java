package com.example.thegarage.entity;

import com.example.thegarage.model.Location;

public class Garage {
    protected Long id;
    protected int levels;
    protected int spacesPerLevel;

    public Garage(Long id, int levels, int spacesPerLevel) {
        this.id = id;
        this.levels = levels;
        this.spacesPerLevel = spacesPerLevel;
    }

    public Long getId() {
        return id;
    }

    public boolean free(Vehicle vehicle) {
        // TODO
        return false;
    }

    public Location assign(Vehicle vehicle) {
        // TODO
        return null;
    }

    public Location locate(Vehicle vehicle) {
        // TODO
        return null;
    }
}
