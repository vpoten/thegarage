package com.example.thegarage.model;

public class GarageOutput {
    private Long id;
    private int levels;
    private int spacesPerLevel;
    private int totalSpaces;
    private int freeSpaces;

    public GarageOutput(Long id, int levels, int spacesPerLevel, int totalSpaces, int freeSpaces) {
        this.id = id;
        this.levels = levels;
        this.spacesPerLevel = spacesPerLevel;
        this.totalSpaces = totalSpaces;
        this.freeSpaces = freeSpaces;
    }

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

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }
}
