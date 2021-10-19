package com.example.thegarage.entity;

import com.example.thegarage.model.Location;

public class Garage {
    private Long id;
    private int levels;
    private int spacesPerLevel;
    private Vehicle[][] assignations;

    public Garage(Long id, int levels, int spacesPerLevel) {
        this.id = id;
        this.levels = levels;
        this.spacesPerLevel = spacesPerLevel;
        this.assignations = new Vehicle[this.levels][this.spacesPerLevel];
        this.clearLocations();
    }

    public Long getId() {
        return id;
    }

    public void free(Location location) {
        this.assignations[location.getLevel()][location.getLot()] = null;
    }

    public void assign(Location location, Vehicle vehicle) {
        this.assignations[location.getLevel()][location.getLot()] = vehicle;
    }

    private void clearLocations() {
        for (int i = 0; i < this.levels; i++) {
            for (int j = 0; j < this.spacesPerLevel; j++) {
                this.assignations[i][j] = null;
            }
        }
    }

    public Location getFirstFreeLocation() {
        for (int i = 0; i < this.levels; i++) {
            for (int j = 0; j < this.spacesPerLevel; j++) {
                if (this.assignations[i][j] == null) {
                    return new Location(this.id, i, j);
                }
            }
        }

        return null;
    }
}
