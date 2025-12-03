package edu.uoc.locuocomotive.model;

import java.time.LocalDate;

public class Passenger {
    private String passport;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String email;

    public Passenger(String passport, String name, String surname, LocalDate birthDate, String email) {
        this.passport = passport;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        setEmail(email);
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,3}");
    }

    // Getters and Setters
    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }
}
