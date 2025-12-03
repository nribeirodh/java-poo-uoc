package edu.uoc.pac3;

public class Position {
    public static final String INVALID_X = "X value must be between 0 and 1024";
    public static final String INVALID_Y = "Y value must be between 0 and 512";

    private static final int MAX_X = 1024;
    private static final int MAX_Y = 512;

    private int x;
    private int y;

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0 || x > MAX_X) {
            throw new IllegalArgumentException(INVALID_X);
        }

        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0 || y > MAX_Y) {
            throw new IllegalArgumentException(INVALID_Y);
        }

        this.y = y;
    }

    public static double distance(Position from, Position to) {
        return Math.sqrt(Math.pow(to.getX() - from.getX(), 2) + Math.pow(to.getY() - from.getY(), 2));
    }
}
