package edu.uoc.locuocomotive.model;

import edu.uoc.locuocomotive.model.StationType;

public class Station {
    private String id;
    private String name;
    private String city;
    private int yearOfOpening;
    private StationType stationType;
    private int xCoordinate;
    private int yCoordinate;
    private String image;

    public Station(String id, String name, String city, int yearOfOpening, StationType stationType, int xCoordinate, int yCoordinate, String image) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.yearOfOpening = yearOfOpening;
        this.stationType = stationType;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfOpening() {
        return yearOfOpening;
    }

    public void setYearOfOpening(int yearOfOpening) {
        this.yearOfOpening = yearOfOpening;
    }

    public StationType getStationType() {
        return stationType;
    }

    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + city + "|" + image + "|" + xCoordinate + "|" + yCoordinate;
    }
}
