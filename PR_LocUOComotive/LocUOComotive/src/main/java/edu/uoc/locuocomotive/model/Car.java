package edu.uoc.locuocomotive.model;

public abstract class Car {
    private String id;

    public Car(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
