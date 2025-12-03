package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 8;

        // Check number of fields
        assertEquals(numFields, Player.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("MAX_STAT").getModifiers()), "The attribute MAX_STAT must be private");
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("MAX_STAT").getModifiers()), "The attribute MAX_STAT must be static");
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("MAX_STAT").getModifiers()), "The attribute MAX_STAT must be final");
            assertEquals(int.class, Player.class.getDeclaredField("MAX_STAT").getType(), "The MAX_STAT attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("currentGold").getModifiers()), "The attribute currentGold must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("currentGold").getModifiers()), "The attribute currentGold cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("currentGold").getModifiers()), "The attribute currentGold cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("currentGold").getType(), "The currentGold attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("currentExperience").getModifiers()), "The attribute currentExperience must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("currentExperience").getModifiers()), "The attribute currentExperience cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("currentExperience").getModifiers()), "The attribute currentExperience cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("currentExperience").getType(), "The currentExperience attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("vitality").getModifiers()), "The attribute vitality must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("vitality").getModifiers()), "The attribute vitality cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("vitality").getModifiers()), "The attribute vitality cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("vitality").getType(), "The vitality attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("intelligence").getModifiers()), "The attribute intelligence must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("intelligence").getModifiers()), "The attribute intelligence cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("intelligence").getModifiers()), "The attribute intelligence cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("intelligence").getType(), "The intelligence attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("strength").getModifiers()), "The attribute strength must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("strength").getModifiers()), "The attribute strength cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("strength").getModifiers()), "The attribute strength cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("strength").getType(), "The strength attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("agility").getModifiers()), "The attribute agility must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("agility").getModifiers()), "The attribute agility cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("agility").getModifiers()), "The attribute agility cannot be final");
            assertEquals(int.class, Player.class.getDeclaredField("agility").getType(), "The agility attribute must be of int type");

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("empire").getModifiers()), "The attribute empire must be private");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("empire").getModifiers()), "The attribute empire cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("empire").getModifiers()), "The attribute empire cannot be final");
            assertEquals(Empire.class, Player.class.getDeclaredField("empire").getType(), "The empire attribute must be of Empire type");
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
        assertEquals(numConstructors, Player.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isProtected(Player.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Empire.class).getModifiers()), "The constructor Player(String, int, int, Position, int, int, int, int, int, int, Empire) must be protected");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 15;

        // Check methods
        assertEquals(numMethods, Player.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getCurrentGold").getModifiers()), "The method getCurrentGold() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getCurrentGold").getModifiers()), "The method getCurrentGold() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getCurrentGold").getModifiers()), "The method getCurrentGold() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getCurrentGold").getReturnType(), "The getCurrentGold() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setCurrentGold", int.class).getModifiers()), "The method setCurrentGold(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setCurrentGold", int.class).getModifiers()), "The method setCurrentGold(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setCurrentGold", int.class).getModifiers()), "The method setCurrentGold(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setCurrentGold", int.class).getReturnType(), "The setCurrentGold(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getCurrentExperience").getModifiers()), "The method getCurrentExperience() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getCurrentExperience").getModifiers()), "The method getCurrentExperience() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getCurrentExperience").getModifiers()), "The method getCurrentExperience() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getCurrentExperience").getReturnType(), "The getCurrentExperience() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setCurrentExperience", int.class).getModifiers()), "The method setCurrentExperience(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setCurrentExperience", int.class).getModifiers()), "The method setCurrentExperience(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setCurrentExperience", int.class).getModifiers()), "The method setCurrentExperience(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setCurrentExperience", int.class).getReturnType(), "The setCurrentExperience(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getVitality").getModifiers()), "The method getVitality() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getVitality").getModifiers()), "The method getVitality() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getVitality").getModifiers()), "The method getVitality() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getVitality").getReturnType(), "The getVitality() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setVitality", int.class).getModifiers()), "The method setVitality(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setVitality", int.class).getModifiers()), "The method setVitality(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setVitality", int.class).getModifiers()), "The method setVitality(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setVitality", int.class).getReturnType(), "The setVitality(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getIntelligence").getModifiers()), "The method getIntelligence() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getIntelligence").getModifiers()), "The method getIntelligence() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getIntelligence").getModifiers()), "The method getIntelligence() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getIntelligence").getReturnType(), "The getIntelligence() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setIntelligence", int.class).getModifiers()), "The method setIntelligence(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setIntelligence", int.class).getModifiers()), "The method setIntelligence(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setIntelligence", int.class).getModifiers()), "The method setIntelligence(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setIntelligence", int.class).getReturnType(), "The setIntelligence(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getStrength").getModifiers()), "The method getStrength() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getStrength").getModifiers()), "The method getStrength() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getStrength").getModifiers()), "The method getStrength() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getStrength").getReturnType(), "The getStrength() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setStrength", int.class).getModifiers()), "The method setStrength(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setStrength", int.class).getModifiers()), "The method setStrength(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setStrength", int.class).getModifiers()), "The method setStrength(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setStrength", int.class).getReturnType(), "The setStrength(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getAgility").getModifiers()), "The method getAgility() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getAgility").getModifiers()), "The method getAgility() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getAgility").getModifiers()), "The method getAgility() cannot be final");
            assertEquals(int.class, Player.class.getDeclaredMethod("getAgility").getReturnType(), "The getAgility() method must return an int");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setAgility", int.class).getModifiers()), "The method setAgility(int) must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setAgility", int.class).getModifiers()), "The method setAgility(int) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setAgility", int.class).getModifiers()), "The method setAgility(int) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setAgility", int.class).getReturnType(), "The setAgility(int) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getEmpire").getModifiers()), "The method getEmpire() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getEmpire").getModifiers()), "The method getEmpire() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getEmpire").getModifiers()), "The method getEmpire() cannot be final");
            assertEquals(Empire.class, Player.class.getDeclaredMethod("getEmpire").getReturnType(), "The getEmpire() method must return an Empire");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("setEmpire", Empire.class).getModifiers()), "The method setEmpire(Empire) must be protected");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setEmpire", Empire.class).getModifiers()), "The method setEmpire(Empire) cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setEmpire", Empire.class).getModifiers()), "The method setEmpire(Empire) cannot be final");
            assertEquals(void.class, Player.class.getDeclaredMethod("setEmpire", Empire.class).getReturnType(), "The setEmpire(Empire) method must return void");

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("sayName").getModifiers()), "The method sayName() must be public");
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("sayName").getModifiers()), "The method sayName() cannot be static");
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("sayName").getModifiers()), "The method sayName() cannot be final");
            assertEquals(String.class, Player.class.getDeclaredMethod("sayName").getReturnType(), "The sayName() method must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertTrue(Speakable.class.isAssignableFrom(Player.class), "Player class must implement Speakable interface");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Entity.class.isAssignableFrom(Player.class), "Player class must inherit from Entity");
    }

    @Test
    @Tag("sanity")
    @Order(6)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(Player.class.getModifiers()), "Player class must be abstract");
    }

}
