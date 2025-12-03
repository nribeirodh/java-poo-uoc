package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionExceptionTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 7;

        // Check attribute fields
        assertEquals(numFields, PositionException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("INVALID_X").getModifiers()), "The attribute INVALID_X must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("INVALID_X").getModifiers()), "The attribute INVALID_X must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("INVALID_X").getModifiers()), "The attribute INVALID_X must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("INVALID_X").getType(), "The INVALID_X attribute must be of String type");

            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("INVALID_Y").getModifiers()), "The attribute INVALID_Y must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("INVALID_Y").getModifiers()), "The attribute INVALID_Y must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("INVALID_Y").getModifiers()), "The attribute INVALID_Y must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("INVALID_Y").getType(), "The INVALID_Y attribute must be of String type");

            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("INVALID_Z").getModifiers()), "The attribute INVALID_Z must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("INVALID_Z").getModifiers()), "The attribute INVALID_Z must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("INVALID_Z").getModifiers()), "The attribute INVALID_Z must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("INVALID_Z").getType(), "The INVALID_Z attribute must be of String type");

            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_X").getModifiers()), "The attribute OUT_OF_BOUNDS_X must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_X").getModifiers()), "The attribute OUT_OF_BOUNDS_X must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_X").getModifiers()), "The attribute OUT_OF_BOUNDS_X must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("OUT_OF_BOUNDS_X").getType(), "The OUT_OF_BOUNDS_X attribute must be of String type");

            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_Y").getModifiers()), "The attribute OUT_OF_BOUNDS_Y must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_Y").getModifiers()), "The attribute OUT_OF_BOUNDS_Y must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("OUT_OF_BOUNDS_Y").getModifiers()), "The attribute OUT_OF_BOUNDS_Y must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("OUT_OF_BOUNDS_Y").getType(), "The OUT_OF_BOUNDS_Y attribute must be of String type");

            assertTrue(Modifier.isPublic(PositionException.class.getDeclaredField("MAP_NULL").getModifiers()), "The attribute MAP_NULL must be public");
            assertTrue(Modifier.isStatic(PositionException.class.getDeclaredField("MAP_NULL").getModifiers()), "The attribute MAP_NULL must be static");
            assertTrue(Modifier.isFinal(PositionException.class.getDeclaredField("MAP_NULL").getModifiers()), "The attribute MAP_NULL must be final");
            assertEquals(String.class, PositionException.class.getDeclaredField("MAP_NULL").getType(), "The MAP_NULL attribute must be of String type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the field: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check constructors
        assertEquals(numConstructors, PositionException.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructors");

        try {
            assertTrue(Modifier.isPublic(PositionException.class.getConstructor(String.class).getModifiers()), "The constructor PositionException(String) must be public");
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
        assertEquals(numMethods, PositionException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(PositionException.class), "PositionException class must inherit from Exception");
    }
}
