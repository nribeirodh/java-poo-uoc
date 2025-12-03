package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnemyTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 8;

        // Check number of fields
        assertEquals(numFields, Enemy.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("MAX_GROUP_LEADER_DISTANCE").getModifiers()), "The attribute MAX_GROUP_LEADER_DISTANCE must be private");
            assertTrue(Modifier.isStatic(Enemy.class.getDeclaredField("MAX_GROUP_LEADER_DISTANCE").getModifiers()), "The attribute MAX_GROUP_LEADER_DISTANCE must be static");
            assertTrue(Modifier.isFinal(Enemy.class.getDeclaredField("MAX_GROUP_LEADER_DISTANCE").getModifiers()), "The attribute MAX_GROUP_LEADER_DISTANCE must be final");
            assertEquals(double.class, Enemy.class.getDeclaredField("MAX_GROUP_LEADER_DISTANCE").getType(), "The MAX_GROUP_LEADER_DISTANCE attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("id").getModifiers()), "The attribute id must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("id").getModifiers()), "The attribute id cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("id").getModifiers()), "The attribute id cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("id").getType(), "The id attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("minGold").getModifiers()), "The attribute minGold must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("minGold").getModifiers()), "The attribute minGold cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("minGold").getModifiers()), "The attribute minGold cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("minGold").getType(), "The minGold attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("maxGold").getModifiers()), "The attribute maxGold must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("maxGold").getModifiers()), "The attribute maxGold cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("maxGold").getModifiers()), "The attribute maxGold cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("maxGold").getType(), "The maxGold attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("experience").getModifiers()), "The attribute experience must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("experience").getModifiers()), "The attribute experience cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("experience").getModifiers()), "The attribute experience cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("experience").getType(), "The experience attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("minDamage").getModifiers()), "The attribute minDamage must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("minDamage").getModifiers()), "The attribute minDamage cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("minDamage").getModifiers()), "The attribute minDamage cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("minDamage").getType(), "The minDamage attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("maxDamage").getModifiers()), "The attribute maxDamage must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("maxDamage").getModifiers()), "The attribute maxDamage cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("maxDamage").getModifiers()), "The attribute maxDamage cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredField("maxDamage").getType(), "The maxDamage attribute must be of int type");

            assertTrue(Modifier.isPrivate(Enemy.class.getDeclaredField("groupLeader").getModifiers()), "The attribute groupLeader must be private");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredField("groupLeader").getModifiers()), "The attribute groupLeader cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredField("groupLeader").getModifiers()), "The attribute groupLeader cannot be final");
            assertEquals(Enemy.class, Enemy.class.getDeclaredField("groupLeader").getType(), "The groupLeader attribute must be of boolean type");
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
        assertEquals(numConstructors, Enemy.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isProtected(Enemy.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Enemy.class).getModifiers()), "The constructor Enemy(String, int, int, Position, int, int, int, int, int, int, Enemy) must be protected");
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

        // Check number of methods
        assertEquals(numMethods, Enemy.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getId").getModifiers()), "The method getId() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getId").getModifiers()), "The method getId() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getId").getModifiers()), "The method getId() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getId").getReturnType(), "The getId() method must return an int");

            assertTrue(Modifier.isProtected(Enemy.class.getDeclaredMethod("setId", int.class).getModifiers()), "The method setId(int) must be protected");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("setId", int.class).getModifiers()), "The method setId(int) cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("setId", int.class).getModifiers()), "The method setId(int) cannot be final");
            assertEquals(void.class, Enemy.class.getDeclaredMethod("setId", int.class).getReturnType(), "The setId(int) method must return void");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getMinGold").getModifiers()), "The method getMinGold() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getMinGold").getModifiers()), "The method getMinGold() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getMinGold").getModifiers()), "The method getMinGold() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getMinGold").getReturnType(), "The getMinGold() method must return an int");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getMaxGold").getModifiers()), "The method getMaxGold() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getMaxGold").getModifiers()), "The method getMaxGold() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getMaxGold").getModifiers()), "The method getMaxGold() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getMaxGold").getReturnType(), "The getMaxGold() method must return an int");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("setGold", int.class, int.class).getModifiers()), "The method setGold(int, int) must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("setGold", int.class, int.class).getModifiers()), "The method setGold(int, int) cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("setGold", int.class, int.class).getModifiers()), "The method setGold(int, int) cannot be final");
            assertEquals(void.class, Enemy.class.getDeclaredMethod("setGold", int.class, int.class).getReturnType(), "The setGold(int, int) method must return void");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getExperience").getModifiers()), "The method getExperience() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getExperience").getModifiers()), "The method getExperience() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getExperience").getModifiers()), "The method getExperience() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getExperience").getReturnType(), "The getExperience() method must return an int");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("setExperience", int.class).getModifiers()), "The method setExperience(int) must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("setExperience", int.class).getModifiers()), "The method setExperience(int) cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("setExperience", int.class).getModifiers()), "The method setExperience(int) cannot be final");
            assertEquals(void.class, Enemy.class.getDeclaredMethod("setExperience", int.class).getReturnType(), "The setExperience(int) method must return void");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getMinDamage").getModifiers()), "The method getMinDamage() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getMinDamage").getModifiers()), "The method getMinDamage() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getMinDamage").getModifiers()), "The method getMinDamage() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getMinDamage").getReturnType(), "The getMinDamage() method must return an int");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getMaxDamage").getModifiers()), "The method getMaxDamage() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getMaxDamage").getModifiers()), "The method getMaxDamage() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getMaxDamage").getModifiers()), "The method getMaxDamage() cannot be final");
            assertEquals(int.class, Enemy.class.getDeclaredMethod("getMaxDamage").getReturnType(), "The getMaxDamage() method must return an int");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("setDamage", int.class, int.class).getModifiers()), "The method setDamage(int, int) must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("setDamage", int.class, int.class).getModifiers()), "The method setDamage(int, int) cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("setDamage", int.class, int.class).getModifiers()), "The method setDamage(int, int) cannot be final");
            assertEquals(void.class, Enemy.class.getDeclaredMethod("setDamage", int.class, int.class).getReturnType(), "The setDamage(int, int) method must return void");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("getGroupLeader").getModifiers()), "The method getGroupLeader() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("getGroupLeader").getModifiers()), "The method getGroupLeader() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("getGroupLeader").getModifiers()), "The method getGroupLeader() cannot be final");
            assertEquals(Enemy.class, Enemy.class.getDeclaredMethod("getGroupLeader").getReturnType(), "The getGroupLeader() method must return an Enemy");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("setGroupLeader", Enemy.class).getModifiers()), "The method setGroupLeader(Enemy) must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("setGroupLeader", Enemy.class).getModifiers()), "The method setGroupLeader(Enemy) cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("setGroupLeader", Enemy.class).getModifiers()), "The method setGroupLeader(Enemy) cannot be final");
            assertEquals(void.class, Enemy.class.getDeclaredMethod("setGroupLeader", Enemy.class).getReturnType(), "The setGroupLeader(Enemy) method must return void");

            assertTrue(Modifier.isPublic(Enemy.class.getDeclaredMethod("isFarFromGroupLeader").getModifiers()), "The method isFarFromGroupLeader() must be public");
            assertFalse(Modifier.isStatic(Enemy.class.getDeclaredMethod("isFarFromGroupLeader").getModifiers()), "The method isFarFromGroupLeader() cannot be static");
            assertFalse(Modifier.isFinal(Enemy.class.getDeclaredMethod("isFarFromGroupLeader").getModifiers()), "The method isFarFromGroupLeader() cannot be final");
            assertEquals(boolean.class, Enemy.class.getDeclaredMethod("isFarFromGroupLeader").getReturnType(), "The isFarFromGroupLeader() method must return a boolean");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Entity.class.isAssignableFrom(Enemy.class), "Enemy class must inherit from Entity");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(Enemy.class.getModifiers()), "Enemy class must be abstract");
    }

}
