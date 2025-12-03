package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapTypeTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Literals definition")
    void checkLiterals() {
        GameMapType[] literalsArray = GameMapType.values();
        List<GameMapType> literals = Arrays.asList(literalsArray);

        assertEquals(literals.size(), 10);

        assertTrue(literals.contains(GameMapType.CITY));
        assertTrue(literals.contains(GameMapType.VALLEY));
        assertTrue(literals.contains(GameMapType.DESERT));
        assertTrue(literals.contains(GameMapType.FOREST));
        assertTrue(literals.contains(GameMapType.MOUNTAIN));
        assertTrue(literals.contains(GameMapType.OCEAN));
        assertTrue(literals.contains(GameMapType.PLAINS));
        assertTrue(literals.contains(GameMapType.ICE));
        assertTrue(literals.contains(GameMapType.VOLCANO));
        assertTrue(literals.contains(GameMapType.TEMPLE));
    }

}
