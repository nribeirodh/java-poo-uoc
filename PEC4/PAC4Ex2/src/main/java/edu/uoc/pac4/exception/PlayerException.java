package edu.uoc.pac4.exception;

public class PlayerException extends Exception {
    public static final String EMPIRE_NULL = "Empire cannot be null";
    public PlayerException(String message) {
        super(message);
    }
}

