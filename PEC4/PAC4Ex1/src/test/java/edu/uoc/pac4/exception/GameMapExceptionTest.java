package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapExceptionTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 6;

        // Check attribute fields
        assertEquals(numFields, GameMapException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("INVALID_GAME_MAP_ID").getModifiers()), "The attribute INVALID_GAME_MAP_ID must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("INVALID_GAME_MAP_ID").getModifiers()), "The attribute INVALID_GAME_MAP_ID must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("INVALID_GAME_MAP_ID").getModifiers()), "The attribute INVALID_GAME_MAP_ID must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("INVALID_GAME_MAP_ID").getType(), "The INVALID_GAME_MAP_ID attribute must be of String type");

            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("INVALID_NAME").getType(), "The INVALID_NAME attribute must be of String type");

            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("INVALID_WIDTH").getModifiers()), "The attribute INVALID_WIDTH must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("INVALID_WIDTH").getModifiers()), "The attribute INVALID_WIDTH must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("INVALID_WIDTH").getModifiers()), "The attribute INVALID_WIDTH must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("INVALID_WIDTH").getType(), "The INVALID_WIDTH attribute must be of String type");

            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("INVALID_HEIGHT").getModifiers()), "The attribute INVALID_HEIGHT must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("INVALID_HEIGHT").getModifiers()), "The attribute INVALID_HEIGHT must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("INVALID_HEIGHT").getModifiers()), "The attribute INVALID_HEIGHT must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("INVALID_HEIGHT").getType(), "The INVALID_HEIGHT attribute must be of String type");

            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("INVALID_DEPTH").getModifiers()), "The attribute INVALID_DEPTH must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("INVALID_DEPTH").getModifiers()), "The attribute INVALID_DEPTH must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("INVALID_DEPTH").getModifiers()), "The attribute INVALID_DEPTH must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("INVALID_DEPTH").getType(), "The INVALID_DEPTH attribute must be of String type");

            assertTrue(Modifier.isPublic(GameMapException.class.getDeclaredField("MAP_TYPE_NULL").getModifiers()), "The attribute MAP_TYPE_NULL must be public");
            assertTrue(Modifier.isStatic(GameMapException.class.getDeclaredField("MAP_TYPE_NULL").getModifiers()), "The attribute MAP_TYPE_NULL must be static");
            assertTrue(Modifier.isFinal(GameMapException.class.getDeclaredField("MAP_TYPE_NULL").getModifiers()), "The attribute MAP_TYPE_NULL must be final");
            assertEquals(String.class, GameMapException.class.getDeclaredField("MAP_TYPE_NULL").getType(), "The MAP_TYPE_NULL attribute must be of String type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, GameMapException.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(GameMapException.class.getConstructor(String.class).getModifiers()), "The constructor GameMapException(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 0;

        // Check number of methods
        assertEquals(numMethods, GameMapException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(GameMapException.class), "GameMapException class must inherit from Exception");
    }

}
