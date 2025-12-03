package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransCloneableTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 1;

        // Check number of methods
        assertEquals(numMethods, TransCloneable.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        final Class<TransCloneable> ownClass = TransCloneable.class;

        try {
            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("transClone").getModifiers()), "The method transClone() must be public");
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("transClone").getModifiers()), "The method transClone() must be abstract");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
