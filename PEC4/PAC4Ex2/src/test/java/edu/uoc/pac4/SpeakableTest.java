package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpeakableTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, Speakable.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        final Class<Speakable> ownClass = Speakable.class;

        try {
            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("sayName").getModifiers()), "The method sayName() must be public");
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("sayName").getModifiers()), "The method sayName() must be abstract");

            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be public");
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be abstract");

            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be public");
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be abstract");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
