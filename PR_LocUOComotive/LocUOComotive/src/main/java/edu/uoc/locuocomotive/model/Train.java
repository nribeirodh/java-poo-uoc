package edu.uoc.locuocomotive.model;

import java.util.List;

public class Train {
    private String id;
    private String model;
    private List<Car> cars;

    public Train(String id, String model, List<Car> cars) {
        this.id = id;
        this.model = model;
        this.cars = cars;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public List<Car> getCars() {
        return cars;
    }
}

