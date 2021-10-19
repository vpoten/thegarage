package com.example.thegarage.model;

public class Location {
    protected Long garageId;
    protected int level;
    protected int lot;

    public Location(Long garageId, int level, int lot) {
        this.garageId = garageId;
        this.level = level;
        this.lot = lot;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }
}
