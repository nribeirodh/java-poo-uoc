package edu.uoc.pac4.exception;

public class EntityException extends Exception {
    public static final String INVALID_NAME = "Name cannot be null or empty";
    public static final String INVALID_LEVEL = "Level must be between 1 and 99";
    public static final String POSITION_NULL = "Position cannot be null";

    public EntityException(String message) {
        super(message);
    }
}


