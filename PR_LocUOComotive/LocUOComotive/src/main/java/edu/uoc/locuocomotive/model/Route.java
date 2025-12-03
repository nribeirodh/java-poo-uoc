package edu.uoc.locuocomotive.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String id;
    private Train train;
    private List<Station> stations;
    private List<Schedule> schedules;

    public Route(String id, Train train, List<Station> stations, List<Schedule> schedules) {
        this.id = id;
        this.train = train;
        this.stations = stations;
        this.schedules = schedules;
    }

    public String getId() {
        return id;
    }

    public Train getTrain() {
        return train;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }
}
