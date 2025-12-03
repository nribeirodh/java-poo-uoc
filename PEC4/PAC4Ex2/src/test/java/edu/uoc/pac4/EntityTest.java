package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntityTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 8;

        // Check attribute fields
        assertEquals(numFields, Entity.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(Entity.class.getDeclaredField("MAX_LEVEL").getModifiers()), "The attribute MAX_LEVEL must be public");
            assertTrue(Modifier.isStatic(Entity.class.getDeclaredField("MAX_LEVEL").getModifiers()), "The attribute MAX_LEVEL must be static");
            assertTrue(Modifier.isFinal(Entity.class.getDeclaredField("MAX_LEVEL").getModifiers()), "The attribute MAX_LEVEL must be final");
            assertEquals(int.class, Entity.class.getDeclaredField("MAX_LEVEL").getType(), "The MAX_LEVEL attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("nextVid").getModifiers()), "The attribute nextVid must be private");
            assertTrue(Modifier.isStatic(Entity.class.getDeclaredField("nextVid").getModifiers()), "The attribute nextVid must be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("nextVid").getModifiers()), "The attribute nextVid cannot be final");
            assertEquals(Integer.class, Entity.class.getDeclaredField("nextVid").getType(), "The nextVid attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("vid").getModifiers()), "The attribute vid must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("vid").getModifiers()), "The attribute vid cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("vid").getModifiers()), "The attribute vid cannot be final");
            assertEquals(Integer.class, Entity.class.getDeclaredField("vid").getType(), "The vid attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("name").getModifiers()), "The attribute name must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("name").getModifiers()), "The attribute name cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("name").getModifiers()), "The attribute name cannot be final");
            assertEquals(String.class, Entity.class.getDeclaredField("name").getType(), "The name attribute must be of String type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("level").getModifiers()), "The attribute level must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("level").getModifiers()), "The attribute level cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("level").getModifiers()), "The attribute level cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredField("level").getType(), "The level attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("maxHP").getModifiers()), "The attribute maxHP must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("maxHP").getModifiers()), "The attribute maxHP cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("maxHP").getModifiers()), "The attribute maxHP cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredField("maxHP").getType(), "The maxHP attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("currentHP").getModifiers()), "The attribute currentHP must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("currentHP").getModifiers()), "The attribute currentHP cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("currentHP").getModifiers()), "The attribute currentHP cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredField("currentHP").getType(), "The currentHP attribute must be of int type");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredField("position").getModifiers()), "The attribute position must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredField("position").getModifiers()), "The attribute position cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredField("position").getModifiers()), "The attribute position cannot be final");
            assertEquals(Position.class, Entity.class.getDeclaredField("position").getType(), "The position attribute must be of Position type");
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
        assertEquals(numConstructors, Entity.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isProtected(Entity.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class).getModifiers()), "The constructor Entity(String, int int, Position) must be protected");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 13;

        // Check methods
        assertEquals(numMethods, Entity.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getNextVid").getModifiers()), "The method getNextVid() must be public");
            assertTrue(Modifier.isStatic(Entity.class.getDeclaredMethod("getNextVid").getModifiers()), "The method getNextVid() must be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getNextVid").getModifiers()), "The method getNextVid() cannot be final");
            assertEquals(Integer.class, Entity.class.getDeclaredMethod("getNextVid").getReturnType(), "The getNextVid() method must return an Integer");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getVid").getModifiers()), "The method getVid() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getVid").getModifiers()), "The method getVid() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getVid").getModifiers()), "The method getVid() cannot be final");
            assertEquals(Integer.class, Entity.class.getDeclaredMethod("getVid").getReturnType(), "The getVid() method must return an Integer");

            assertTrue(Modifier.isPrivate(Entity.class.getDeclaredMethod("setVid").getModifiers()), "The method setVid() must be private");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setVid").getModifiers()), "The method setVid() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setVid").getModifiers()), "The method setVid() cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setVid").getReturnType(), "The setVid() method must return void");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getName").getModifiers()), "The method getName() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getName").getModifiers()), "The method getName() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getName").getModifiers()), "The method getName() cannot be final");
            assertEquals(String.class, Entity.class.getDeclaredMethod("getName").getReturnType(), "The getName() method must return a String");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setName", String.class).getReturnType(), "The setName(String) method must return void");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getLevel").getModifiers()), "The method getLevel() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getLevel").getModifiers()), "The method getLevel() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getLevel").getModifiers()), "The method getLevel() cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredMethod("getLevel").getReturnType(), "The getLevel() method must return an int");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("setLevel", int.class).getModifiers()), "The method setLevel(int) must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setLevel", int.class).getModifiers()), "The method setLevel(int) cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setLevel", int.class).getModifiers()), "The method setLevel(int) cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setLevel", int.class).getReturnType(), "The setLevel(int) method must return void");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getPosition").getModifiers()), "The method getPosition() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getPosition").getModifiers()), "The method getPosition() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getPosition").getModifiers()), "The method getPosition() cannot be final");
            assertEquals(Position.class, Entity.class.getDeclaredMethod("getPosition").getReturnType(), "The getPosition() method must return a Position");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("setPosition", Position.class).getModifiers()), "The method setPosition(Position) must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setPosition", Position.class).getModifiers()), "The method setPosition(Position) cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setPosition", Position.class).getModifiers()), "The method setPosition(Position) cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setPosition", Position.class).getReturnType(), "The setPosition(Position) method must return void");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getMaxHP").getModifiers()), "The method getMaxHP() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getMaxHP").getModifiers()), "The method getMaxHP() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getMaxHP").getModifiers()), "The method getMaxHP() cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredMethod("getMaxHP").getReturnType(), "The getMaxHP() method must return an int");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("setMaxHP", int.class).getModifiers()), "The method setMaxHP(int) must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setMaxHP", int.class).getModifiers()), "The method setMaxHP(int) cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setMaxHP", int.class).getModifiers()), "The method setMaxHP(int) cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setMaxHP", int.class).getReturnType(), "The setMaxHP(int) method must return void");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("getCurrentHP").getModifiers()), "The method getCurrentHP() must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("getCurrentHP").getModifiers()), "The method getCurrentHP() cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("getCurrentHP").getModifiers()), "The method getCurrentHP() cannot be final");
            assertEquals(int.class, Entity.class.getDeclaredMethod("getCurrentHP").getReturnType(), "The getCurrentHP() method must return an int");

            assertTrue(Modifier.isPublic(Entity.class.getDeclaredMethod("setCurrentHP", int.class).getModifiers()), "The method setCurrentHP(int) must be public");
            assertFalse(Modifier.isStatic(Entity.class.getDeclaredMethod("setCurrentHP", int.class).getModifiers()), "The method setCurrentHP(int) cannot be static");
            assertFalse(Modifier.isFinal(Entity.class.getDeclaredMethod("setCurrentHP", int.class).getModifiers()), "The method setCurrentHP(int) cannot be final");
            assertEquals(void.class, Entity.class.getDeclaredMethod("setCurrentHP", int.class).getReturnType(), "The setCurrentHP(int) method must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertTrue(Movable.class.isAssignableFrom(Entity.class), "Entity class must implement Movable interface");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(Entity.class.getModifiers()), "Entity class must be abstract");
    }

}
