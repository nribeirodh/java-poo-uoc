package edu.uoc.pac4;

import edu.uoc.pac4.exception.GameMapException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapEqualsToStringTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Overriding methods")
    void checkOverridingMethods() {
        try {
            assertEquals(GameMap.class.getDeclaredMethod("equals", Object.class).getDeclaringClass(), GameMap.class, "The equals method must be overridden in GameMap class");
            assertEquals(GameMap.class.getDeclaredMethod("toString").getDeclaringClass(), GameMap.class, "The toString method must be overridden in GameMap class");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("minimum")
    @Order(2)
    @DisplayName("Minimum - equals")
    void equalsTest() {
        GameMap gameMap1 = null;
        GameMap gameMap2 = null;
        GameMap gameMap3 = null;
        GameMap gameMap4 = null;
        GameMap gameMap5 = null;

        try {
            gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            gameMap2 = new GameMap(1, "Area Bakra", 1024, 1536, 512, GameMapType.CITY);
            gameMap3 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            gameMap4 = new GameMap(3, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            gameMap5 = new GameMap(1, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }

        assertEquals(gameMap1, gameMap2, "The equals method must return true for two GameMap objects with the same game map ID");
        assertNotEquals(gameMap1, gameMap3, "The equals method must return false for two GameMap objects with different game map ID");
        assertNotEquals(gameMap3, gameMap4, "The equals method must return false for two GameMap objects with different game map ID");
        assertEquals(gameMap1, gameMap5, "The equals method must return false for two GameMap objects with the same game map ID");
    }

    @Test
    @Tag("minimum")
    @Order(3)
    @DisplayName("Minimum - toString")
    void toStringTest() {
        GameMap gameMap1 = null;
        GameMap gameMap2 = null;
        GameMap gameMap3 = null;

        try {
            gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            gameMap2 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            gameMap3 = new GameMap(3, "Doyyumhwan", 1536, 1536, 1024, GameMapType.VOLCANO);
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }

        assertEquals("1 | Area Joan (1024x1536x512) | City", gameMap1.toString(), "The toString method must return the expected string");
        assertEquals("2 | Valley of Seungryong (1536x1536x512) | Valley", gameMap2.toString(), "The toString method must return the expected string");
        assertEquals("3 | Doyyumhwan (1536x1536x1024) | Volcano", gameMap3.toString(), "The toString method must return the expected string");
    }

}
