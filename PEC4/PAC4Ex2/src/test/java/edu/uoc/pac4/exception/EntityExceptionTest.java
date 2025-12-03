package edu.uoc.pac4.exception;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntityExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 3;

        // Check attribute fields
        assertEquals(numFields, EntityException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(EntityException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be public");
            assertTrue(Modifier.isStatic(EntityException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be static");
            assertTrue(Modifier.isFinal(EntityException.class.getDeclaredField("INVALID_NAME").getModifiers()), "The attribute INVALID_NAME must be final");
            assertEquals(String.class, EntityException.class.getDeclaredField("INVALID_NAME").getType(), "The INVALID_NAME attribute must be of String type");

            assertTrue(Modifier.isPublic(EntityException.class.getDeclaredField("INVALID_LEVEL").getModifiers()), "The attribute INVALID_LEVEL must be public");
            assertTrue(Modifier.isStatic(EntityException.class.getDeclaredField("INVALID_LEVEL").getModifiers()), "The attribute INVALID_LEVEL must be static");
            assertTrue(Modifier.isFinal(EntityException.class.getDeclaredField("INVALID_LEVEL").getModifiers()), "The attribute INVALID_LEVEL must be final");
            assertEquals(String.class, EntityException.class.getDeclaredField("INVALID_LEVEL").getType(), "The INVALID_LEVEL attribute must be of String type");

            assertTrue(Modifier.isPublic(EntityException.class.getDeclaredField("POSITION_NULL").getModifiers()), "The attribute POSITION_NULL must be public");
            assertTrue(Modifier.isStatic(EntityException.class.getDeclaredField("POSITION_NULL").getModifiers()), "The attribute POSITION_NULL must be static");
            assertTrue(Modifier.isFinal(EntityException.class.getDeclaredField("POSITION_NULL").getModifiers()), "The attribute POSITION_NULL must be final");
            assertEquals(String.class, EntityException.class.getDeclaredField("POSITION_NULL").getType(), "The POSITION_NULL attribute must be of String type");
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

        // Check number of constructors
        assertEquals(numConstructors, EntityException.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(EntityException.class.getConstructor(String.class).getModifiers()), "The constructor EntityException(String) must be public");
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
        assertEquals(numMethods, EntityException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(EntityException.class), "EntityException class must inherit from Exception");
    }
}
