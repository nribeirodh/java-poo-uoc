package edu.uoc.locuocomotive.model;

public class Ticket {
    private String routeId;
    private Passenger passenger;
    private String seatReference;
    private double price;
    private String departureStation;
    private String arrivalStation;
    private String departureTime;
    private String arrivalTime;

    public Ticket(Passenger passenger, String seatReference, double price, String departureStation, String arrivalStation, String departureTime, String arrivalTime) {
        this.passenger = passenger;
        this.seatReference = seatReference;
        this.price = price;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public Passenger getPassenger() {
        return passenger;
    }

    public String getSeatReference() {
        return seatReference;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setSeatReference(String seatReference) {
        this.seatReference = seatReference;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

}
