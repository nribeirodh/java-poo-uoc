package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DPOOVectorTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsDefinition() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, DPOOVector.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPrivate(DPOOVector.class.getDeclaredField("elements").getModifiers()), "The 'elements' attribute must be private");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredField("elements").getModifiers()), "The 'elements' attribute cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredField("elements").getModifiers()), "The 'elements' attribute cannot be final");
            assertEquals(Object[].class, DPOOVector.class.getDeclaredField("elements").getType(), "The 'elements' attribute must be of type T[]");

            assertTrue(Modifier.isPrivate(DPOOVector.class.getDeclaredField("size").getModifiers()), "The 'size' attribute must be private");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredField("size").getModifiers()), "The 'size' attribute cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredField("size").getModifiers()), "The 'size' attribute cannot be final");
            assertEquals(int.class, DPOOVector.class.getDeclaredField("size").getType(), "The 'size' attribute must be of type int");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorDefinition() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, DPOOVector.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(DPOOVector.class.getConstructor(int.class).getModifiers()), "The constructor must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsDefinition() {
        int numMethods = 4;

        // Check number of methods
        assertEquals(numMethods, DPOOVector.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(DPOOVector.class.getDeclaredMethod("add", Object.class).getModifiers()), "The 'add' method must be public");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredMethod("add", Object.class).getModifiers()), "The 'add' method cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredMethod("add", Object.class).getModifiers()), "The 'add' method cannot be final");
            assertEquals(boolean.class, DPOOVector.class.getDeclaredMethod("add", Object.class).getReturnType(), "The 'add' method must return a boolean");

            assertTrue(Modifier.isPublic(DPOOVector.class.getDeclaredMethod("size").getModifiers()), "The 'size' method must be public");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredMethod("size").getModifiers()), "The 'size' method cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredMethod("size").getModifiers()), "The 'size' method cannot be final");
            assertEquals(int.class, DPOOVector.class.getDeclaredMethod("size").getReturnType(), "The 'size' method must return an int");

            assertTrue(Modifier.isPublic(DPOOVector.class.getDeclaredMethod("get", int.class).getModifiers()), "The 'get' method must be public");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredMethod("get", int.class).getModifiers()), "The 'get' method cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredMethod("get", int.class).getModifiers()), "The 'get' method cannot be final");
            assertEquals(Object.class, DPOOVector.class.getDeclaredMethod("get", int.class).getReturnType(), "The 'get' method must return an Object");

            assertTrue(Modifier.isPublic(DPOOVector.class.getDeclaredMethod("remove", int.class).getModifiers()), "The 'remove' method must be public");
            assertFalse(Modifier.isStatic(DPOOVector.class.getDeclaredMethod("remove", int.class).getModifiers()), "The 'remove' method cannot be static");
            assertFalse(Modifier.isFinal(DPOOVector.class.getDeclaredMethod("remove", int.class).getModifiers()), "The 'remove' method cannot be final");
            assertEquals(void.class, DPOOVector.class.getDeclaredMethod("remove", int.class).getReturnType(), "The 'remove' method must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test - Add elements")
    public void testAddElements() {
        DPOOVector<Integer> vector = new DPOOVector<>(5);

        assertTrue(vector.add(1), "The 'add' method must return true when adding an element");
        assertEquals(1, vector.size(), "The 'size' method must return 1 after adding an element");
        assertEquals(1, vector.get(0), "The 'get' method must return the element added");
        assertNull(vector.get(1), "The 'get' method must return null when trying to get an element out of bounds");

        assertTrue(vector.add(2), "The 'add' method must return true when adding an element");
        assertEquals(2, vector.size(), "The 'size' method must return 2 after adding an element");

        assertTrue(vector.add(3), "The 'add' method must return true when adding an element");
        assertEquals(3, vector.size(), "The 'size' method must return 3 after adding an element");

        assertTrue(vector.add(4), "The 'add' method must return true when adding an element");
        assertEquals(4, vector.size(), "The 'size' method must return 4 after adding an element");

        assertTrue(vector.add(5), "The 'add' method must return true when adding an element");
        assertEquals(5, vector.size(), "The 'size' method must return 5 after adding an element");

        assertFalse(vector.add(6), "The 'add' method must return false when trying to add an element to a full vector");
        assertEquals(5, vector.size(), "The 'size' method must return 5 after trying to add an element to a full vector");

        assertEquals(1, vector.get(0), "The 'get' method must return the first element added");
        assertEquals(2, vector.get(1), "The 'get' method must return the second element added");
        assertEquals(3, vector.get(2), "The 'get' method must return the third element added");
        assertEquals(4, vector.get(3), "The 'get' method must return the fourth element added");
        assertEquals(5, vector.get(4), "The 'get' method must return the fifth element added");

        DPOOVector<String> vector2 = new DPOOVector<>(3);

        assertFalse(vector2.add(null), "The 'add' method must return false when trying to add a null element");
        assertEquals(0, vector2.size(), "The 'size' method must return 0 after trying to add a null element");

        assertTrue(vector2.add("DPOO"), "The 'add' method must return true when adding an element");
        assertEquals(1, vector2.size(), "The 'size' method must return 1 after adding an element");

        assertTrue(vector2.add("UOC"), "The 'add' method must return true when adding an element");
        assertEquals(2, vector2.size(), "The 'size' method must return 2 after adding an element");

        assertTrue(vector2.add("UOCoders"), "The 'add' method must return true when adding an element");
        assertEquals(3, vector2.size(), "The 'size' method must return 3 after adding an element");

        assertFalse(vector2.add("SpinUOC"), "The 'add' method must return false when trying to add an element to a full vector");
        assertEquals(3, vector2.size(), "The 'size' method must return 3 after trying to add an element to a full vector");

        assertEquals("DPOO", vector2.get(0), "The 'get' method must return the first element added");
        assertEquals("UOC", vector2.get(1), "The 'get' method must return the second element added");
        assertEquals("UOCoders", vector2.get(2), "The 'get' method must return the third element added");
    }

    @Test
    @Order(5)
    @DisplayName("Test - Remove elements")
    public void testRemoveElements() {
        DPOOVector<Integer> vector = new DPOOVector<>(5);

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);

        vector.remove(0);
        assertEquals(4, vector.size(), "The 'size' method must return 4 after removing an element");
        assertEquals(2, vector.get(0), "The 'get' method must return the first element after removing the first element");
        assertEquals(3, vector.get(1), "The 'get' method must return the second element after removing the first element");
        assertEquals(4, vector.get(2), "The 'get' method must return the third element after removing the first element");
        assertEquals(5, vector.get(3), "The 'get' method must return the fourth element after removing the first element");
        assertNull(vector.get(4), "The 'get' method must return null after removing the first element");

        vector.remove(2);
        assertEquals(3, vector.size(), "The 'size' method must return 3 after removing an element");
        assertEquals(2, vector.get(0), "The 'get' method must return the first element after removing the third element");
        assertEquals(3, vector.get(1), "The 'get' method must return the second element after removing the third element");
        assertEquals(5, vector.get(2), "The 'get' method must return the third element after removing the third element");
        assertNull(vector.get(3), "The 'get' method must return null after removing the third element");

        vector.remove(1);
        assertEquals(2, vector.size(), "The 'size' method must return 2 after removing an element");
        assertEquals(2, vector.get(0), "The 'get' method must return the first element after removing the second element");
        assertEquals(5, vector.get(1), "The 'get' method must return the second element after removing the second element");
        assertNull(vector.get(2), "The 'get' method must return null after removing the second element");

        vector.remove(1);
        assertEquals(1, vector.size(), "The 'size' method must return 1 after removing an element");
        assertEquals(2, vector.get(0), "The 'get' method must return the first element after removing the second element");
        assertNull(vector.get(1), "The 'get' method must return null after removing the second element");

        vector.remove(0);
        assertEquals(0, vector.size(), "The 'size' method must return 0 after removing the last element");
        assertNull(vector.get(0), "The 'get' method must return null after removing the last element");

        DPOOVector<String> vector2 = new DPOOVector<>(3);

        vector2.add("DPOO");
        vector2.add("UOC");
        vector2.add("UOCoders");

        vector2.remove(-1);
        assertEquals(3, vector2.size(), "The 'size' method must return 3 after trying to remove an element with a negative index");

        vector2.remove(3);
        assertEquals(3, vector2.size(), "The 'size' method must return 3 after trying to remove an element with an index out of bounds");

        vector2.remove(1);
        assertEquals(2, vector2.size(), "The 'size' method must return 2 after removing an element");
        assertEquals("DPOO", vector2.get(0), "The 'get' method must return the first element after removing the second element");
        assertEquals("UOCoders", vector2.get(1), "The 'get' method must return the second element after removing the second element");
        assertNull(vector2.get(2), "The 'get' method must return null after removing the second element");

        vector2.remove(1);
        assertEquals(1, vector2.size(), "The 'size' method must return 1 after removing an element");
        assertEquals("DPOO", vector2.get(0), "The 'get' method must return the first element after removing the second element");
        assertNull(vector2.get(1), "The 'get' method must return null after removing the second element");

        vector2.remove(0);
        assertEquals(0, vector2.size(), "The 'size' method must return 0 after removing the last element");
        assertNull(vector2.get(0), "The 'get' method must return null after removing the last element");

        vector2.remove(0);
        assertEquals(0, vector2.size(), "The 'size' method must return 0 after trying to remove an element from an empty vector");
    }
}
