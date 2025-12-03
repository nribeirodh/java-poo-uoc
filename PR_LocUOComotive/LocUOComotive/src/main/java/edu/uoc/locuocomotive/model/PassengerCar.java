package edu.uoc.locuocomotive.model;

public class PassengerCar extends Car {
    private SeatClass seatClass;
    private int seatCount;

    public PassengerCar(String id, SeatClass seatClass, int seatCount) {
        super(id);
        this.seatClass = seatClass;
        this.seatCount = seatCount;
    }

    // Getters and Setters
    public SeatClass getSeatClass() {
        return seatClass;
    }

    public int getSeatCount() {
        return seatCount;
    }
}

