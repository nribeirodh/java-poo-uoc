package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionEqualsToStringTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Overriding methods")
    void checkOverridingMethods() {
        try {
            assertEquals(Position.class.getDeclaredMethod("equals", Object.class).getDeclaringClass(), Position.class, "The equals method must be overridden in Position class");
            assertEquals(Position.class.getDeclaredMethod("toString").getDeclaringClass(), Position.class, "The toString method must be overridden in Position class");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("minimum")
    @Order(2)
    @DisplayName("Minimum - Equals")
    void equalsTest() {
        try {
            GameMap gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            GameMap gameMap2 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            Position position1 = new Position(gameMap1, 100, 50, 10);
            Position position2 = new Position(gameMap1, 100, 50, 10);
            Position position3 = new Position(gameMap1, 200, 100, 0);

            assertEquals(position1, position2);
            assertNotEquals(position1, position3);

            position2.setGameMap(gameMap2);

            assertNotEquals(position1, position2);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the equals method of the Position object: " + e.getMessage());
        }
    }

    @Test
    @Tag("minimum")
    @Order(3)
    @DisplayName("Minimum - toString")
    void toStringTest() {
        GameMap gameMap;
        Position position = null;

        try {
            gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            position = new Position(gameMap, 100, 50, 10);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Position object: " + e.getMessage());
        }

        assertEquals("1 | Area Joan (1024x1536x512) | City | Position: (100, 50, 10)", position.toString());
    }

}
