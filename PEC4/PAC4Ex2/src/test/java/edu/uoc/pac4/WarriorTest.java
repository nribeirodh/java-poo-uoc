package edu.uoc.pac4;

import edu.uoc.pac4.exception.PlayerException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WarriorTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 6;

        // Check number of fields
        assertEquals(numFields, Warrior.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be final");
            assertEquals(int.class, Warrior.class.getDeclaredField("VITALITY").getType(), "The VITALITY field must be of int type");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be final");
            assertEquals(int.class, Warrior.class.getDeclaredField("INTELLIGENCE").getType(), "The INTELLIGENCE field must be of int type");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be final");
            assertEquals(int.class, Warrior.class.getDeclaredField("STRENGTH").getType(), "The STRENGTH field must be of int type");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be final");
            assertEquals(int.class, Warrior.class.getDeclaredField("AGILITY").getType(), "The AGILITY field must be of int type");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, Warrior.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPrivate(Warrior.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(Warrior.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(Warrior.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, Warrior.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the field: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 2;

        // Check constructors
        assertEquals(numConstructors, Warrior.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredConstructor(String.class, Position.class, Empire.class).getModifiers()), "The constructor Warrior(String, Position, Empire) must be public");
            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Empire.class).getModifiers()), "The constructor Warrior(String, int, int, Position, int, int, int, int, int, int, Empire) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, Warrior.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        try {
            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(Warrior.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(Warrior.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, Warrior.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must be boolean");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be public");
            assertFalse(Modifier.isStatic(Warrior.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be static");
            assertFalse(Modifier.isFinal(Warrior.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be final");
            assertEquals(String.class, Warrior.class.getDeclaredMethod("battleCry").getReturnType(), "The battleCry() method must be void");

            assertTrue(Modifier.isPublic(Warrior.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be public");
            assertFalse(Modifier.isStatic(Warrior.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be static");
            assertFalse(Modifier.isFinal(Warrior.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be final");
            assertEquals(String.class, Warrior.class.getDeclaredMethod("deathCry").getReturnType(), "The deathCry() method must be void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Player.class.isAssignableFrom(Warrior.class), "Warrior class must inherit from Player");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Warrior.class.getModifiers()), "Warrior class cannot be abstract");
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Creation default")
    void createWarriorDefaultTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("Warrior", position, Empire.JINNO);

            assertEquals("Warrior", warrior.getName());
            assertEquals(1, warrior.getLevel());
            assertEquals(250, warrior.getMaxHP());
            assertEquals(250, warrior.getCurrentHP());
            assertEquals(position, warrior.getPosition());
            assertEquals(Empire.JINNO, warrior.getEmpire());
            assertEquals(0, warrior.getCurrentGold());
            assertEquals(0, warrior.getCurrentExperience());
            assertEquals(4, warrior.getVitality());
            assertEquals(3, warrior.getIntelligence());
            assertEquals(6, warrior.getStrength());
            assertEquals(3, warrior.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation custom values")
    void createWarriorTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("Warrior", 90, 1000, position, 1000000, 55000000, 90, 10, 90, 50, Empire.JINNO);

            assertEquals("Warrior", warrior.getName());
            assertEquals(90, warrior.getLevel());
            assertEquals(1000, warrior.getMaxHP());
            assertEquals(1000, warrior.getCurrentHP());
            assertEquals(position, warrior.getPosition());
            assertEquals(Empire.JINNO, warrior.getEmpire());
            assertEquals(1000000, warrior.getCurrentGold());
            assertEquals(55000000, warrior.getCurrentExperience());
            assertEquals(90, warrior.getVitality());
            assertEquals(10, warrior.getIntelligence());
            assertEquals(90, warrior.getStrength());
            assertEquals(50, warrior.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid empire")
    void createWarriorInvalidEmpireTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);

            assertThrows(PlayerException.class, () -> {
                new Warrior("Warrior", position, null);
            });

            Warrior warrior = new Warrior("Warrior", position, Empire.JINNO);

            assertThrows(PlayerException.class, () -> {
                warrior.setEmpire(null);
            });
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Creation invalid stats")
    void createWarriorInvalidStatsTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("Warrior", 90, 1000, position, 1000000, 55000000, 91, -1, 90, 50, Empire.JINNO);

            assertEquals(90, warrior.getVitality());
            assertEquals(0, warrior.getIntelligence());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Creation invalid stats")
    void createWarriorInvalidGoldExpTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("Warrior", 90, 0, position, -1, -1, 90, 10, 90, 50, Empire.JINNO);

            assertEquals(1, warrior.getMaxHP());
            assertEquals(0, warrior.getCurrentHP());
            assertEquals(0, warrior.getCurrentGold());
            assertEquals(0, warrior.getCurrentExperience());

            warrior.setCurrentHP(-1);

            assertEquals(0, warrior.getCurrentHP());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Move")
    void moveWarriorTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("Warrior", position, Empire.JINNO);

            assertTrue(warrior.move(new Position(gameMap, 100, 70, 10)));
            assertEquals(new Position(gameMap, 100, 70, 10), warrior.getPosition());

            assertFalse(warrior.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 70, 10), warrior.getPosition());

            assertTrue(warrior.move(new Position(gameMap, 111, 78, 24)));
            assertEquals(new Position(gameMap, 111, 78, 24), warrior.getPosition());

            assertFalse(warrior.move(new Position(gameMap, 124, 86, 38)));
            assertEquals(new Position(gameMap, 111, 78, 24), warrior.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Battle cry")
    void battleCryWarriorTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("MyName", position, Empire.JINNO);

            assertEquals("MyName: To victory or death!", warrior.battleCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Warrior object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Death cry")
    void deathCryWarriorTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Warrior warrior = new Warrior("MyName", position, Empire.JINNO);

            assertEquals("MyName: I shall return, stronger than ever...", warrior.deathCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Warrior object: " + e.getMessage());
        }
    }
}
