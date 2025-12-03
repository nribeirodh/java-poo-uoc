package edu.uoc.pac4.exception;

public class GameMapException extends Exception {
    public static final String INVALID_GAME_MAP_ID = "Game map ID cannot be negative or zero";
    public static final String INVALID_NAME = "Name cannot be null or empty";
    public static final String INVALID_WIDTH = "Width cannot be negative or zero";
    public static final String INVALID_HEIGHT = "Height cannot be negative or zero";
    public static final String INVALID_DEPTH = "Depth cannot be negative or zero";
    public static final String MAP_TYPE_NULL = "Game map type cannot be null";

    public GameMapException(String message) {
        super(message);
    }
}




