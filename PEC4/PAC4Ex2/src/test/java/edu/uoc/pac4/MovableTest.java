package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovableTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 1;

        // Check number of methods
        assertEquals(numMethods, Movable.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        final Class<Movable> ownClass = Movable.class;

        try {
            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be abstract");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
