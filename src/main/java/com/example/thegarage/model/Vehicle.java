package com.example.thegarage.model;


public class Vehicle {
    protected String id;  // the license plate id
    protected Garage garage = null;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        if (this.garage != null) {
            // TODO raise exception
        }
        this.garage = garage;
    }

    public Location locate() {
        if (this.garage != null) {
            return this.garage.locate(this);
        } else {
            return null;
        }
    }

    public void exit() {
        if (this.garage == null) {
            // TODO raise exception
        }
        this.garage.free(this);
    }
}
