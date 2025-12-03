package edu.uoc.locuocomotive.model;

import java.time.LocalTime;
import java.util.List;

public class Schedule {
    private int stationId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int travelTime;
    private int startStationId;
    private int endStationId;

    public Schedule(int stationId, LocalTime departureTime, LocalTime arrivalTime, int travelTime, int startStationId, int endStationId) {
        this.stationId = stationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelTime = travelTime;
        this.startStationId = startStationId;
        this.endStationId = endStationId;
    }

    public int getStationId() {
        return stationId;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public int getStartStationId() {
        return startStationId;
    }

    public int getEndStationId() {
        return endStationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setStartStationId(int startStationId) {
        this.startStationId = startStationId;
    }

    public void setEndStationId(int endStationId) {
        this.endStationId = endStationId;
    }
}
