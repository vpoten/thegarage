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
        this.assignations = new Vehicle[this.getLevels()][this.getSpacesPerLevel()];
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
        for (int i = 0; i < this.getLevels(); i++) {
            for (int j = 0; j < this.getSpacesPerLevel(); j++) {
                this.assignations[i][j] = null;
            }
        }
    }

    public Location getFirstFreeLocation() {
        for (int i = 0; i < this.getLevels(); i++) {
            for (int j = 0; j < this.getSpacesPerLevel(); j++) {
                if (this.assignations[i][j] == null) {
                    return new Location(this.getId(), i, j);
                }
            }
        }

        return null;
    }

    public int getLevels() {
        return levels;
    }

    public int getSpacesPerLevel() {
        return spacesPerLevel;
    }

    public int getTotalSpaces() {
        return this.getLevels() * this.getSpacesPerLevel();
    }

    public int getFreeSpaces() {
        int free = 0;

        for (int i = 0; i < this.getLevels(); i++) {
            for (int j = 0; j < this.getSpacesPerLevel(); j++) {
                if (this.assignations[i][j] == null) {
                    free++;
                }
            }
        }

        return free;
    }
}
