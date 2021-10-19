package com.example.thegarage.model;

public class GarageInput {
    private Long id;
    private int levels;
    private int spacesPerLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getSpacesPerLevel() {
        return spacesPerLevel;
    }

    public void setSpacesPerLevel(int spacesPerLevel) {
        this.spacesPerLevel = spacesPerLevel;
    }
}
