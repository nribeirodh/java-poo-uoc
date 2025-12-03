package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapTypeToStringTest {

    @Test
    @Tag("minimum")
    @Order(1)
    @DisplayName("Minimum - toString")
    void testToString() {
        assertEquals("City", GameMapType.CITY.toString());
        assertEquals("Valley", GameMapType.VALLEY.toString());
        assertEquals("Desert", GameMapType.DESERT.toString());
        assertEquals("Forest", GameMapType.FOREST.toString());
        assertEquals("Mountain", GameMapType.MOUNTAIN.toString());
        assertEquals("Ocean", GameMapType.OCEAN.toString());
        assertEquals("Plains", GameMapType.PLAINS.toString());
        assertEquals("Ice", GameMapType.ICE.toString());
        assertEquals("Volcano", GameMapType.VOLCANO.toString());
        assertEquals("Temple", GameMapType.TEMPLE.toString());
    }

}
