package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 1;

        // Check attribute fields
        assertEquals(numFields, PlayerException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(PlayerException.class.getDeclaredField("EMPIRE_NULL").getModifiers()), "The attribute EMPIRE_NULL must be public");
            assertTrue(Modifier.isStatic(PlayerException.class.getDeclaredField("EMPIRE_NULL").getModifiers()), "The attribute EMPIRE_NULL must be static");
            assertTrue(Modifier.isFinal(PlayerException.class.getDeclaredField("EMPIRE_NULL").getModifiers()), "The attribute EMPIRE_NULL must be final");
            assertEquals(String.class, PlayerException.class.getDeclaredField("EMPIRE_NULL").getType(), "The EMPIRE_NULL attribute must be of String type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the field: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check constructors
        assertEquals(numConstructors, PlayerException.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructors");

        try {
            assertTrue(Modifier.isPublic(PlayerException.class.getConstructor(String.class).getModifiers()), "The constructor PlayerException(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 0;

        // Check number of methods
        assertEquals(numMethods, PlayerException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(PlayerException.class), "PlayerException class must inherit from Exception");
    }

}
