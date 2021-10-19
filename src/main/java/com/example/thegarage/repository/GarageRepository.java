package com.example.thegarage.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.thegarage.entity.Garage;

import java.util.Collection;
import java.util.HashMap;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GarageRepository {
    protected HashMap<Long, Garage> garages = new HashMap<Long, Garage>();

    public Garage findById(Long id) {
        return this.garages.get(id);
    }

    public void insert(Garage garage) {
        this.garages.put(garage.getId(), garage);
    }

    public Collection<Garage> list() {
        return this.garages.values();
    }
}
