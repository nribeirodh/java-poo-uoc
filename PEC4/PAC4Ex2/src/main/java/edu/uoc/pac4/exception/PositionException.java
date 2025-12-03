package edu.uoc.pac4.exception;

public class PositionException extends Exception {
    public static final String INVALID_X = "The x coordinate must be greater than or equal to 0";
    public static final String INVALID_Y = "The y coordinate must be greater than or equal to 0";
    public static final String INVALID_Z = "The z coordinate must be greater than or equal to 0";
    public static final String OUT_OF_BOUNDS_X = "The x coordinate is out of bounds";
    public static final String OUT_OF_BOUNDS_Y = "The y coordinate is out of bounds";
    public static final String OUT_OF_BOUNDS_Z = "The z coordinate is out of bounds";
    public static final String MAP_NULL = "The map cannot be null";

    public PositionException(String message) {
        super(message);
    }
}
