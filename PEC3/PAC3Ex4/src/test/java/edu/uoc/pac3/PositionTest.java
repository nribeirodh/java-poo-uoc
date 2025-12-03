package edu.uoc.pac3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionTest {

    @Test
    @Order(1)
    @DisplayName("Constructor assigns values correctly")
    public void testValidConstructor() {
        Position position = new Position(512, 256);
        assertEquals(512, position.getX());
        assertEquals(256, position.getY());
    }

    @Test
    @Order(2)
    @DisplayName("Throw IllegalArgumentException for invalid X")
    public void testSetXInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Position(1025, 100));
        assertEquals(Position.INVALID_X, exception.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Throw IllegalArgumentException for invalid Y")
    public void testSetYInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Position(100, 513));
        assertEquals(Position.INVALID_Y, exception.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName("Calculate distance correctly")
    public void testDistance() {
        Position from = new Position(0, 0);
        Position to = new Position(3, 4); // 3-4-5 triangle
        assertEquals(5.0, Position.distance(from, to));
    }

    @Test
    @Order(5)
    @DisplayName("Set X within bounds")
    public void testSetXValid() {
        Position position = new Position(0, 0);
        position.setX(1024);
        assertEquals(1024, position.getX());
    }

    @Test
    @Order(6)
    @DisplayName("Set Y within bounds")
    public void testSetYValid() {
        Position position = new Position(0, 0);
        position.setY(512);
        assertEquals(512, position.getY());
    }
}
