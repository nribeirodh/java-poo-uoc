package edu.uoc.pac4;

import edu.uoc.pac4.exception.PlayerException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NinjaTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 6;

        // Check number of fields
        assertEquals(numFields, Ninja.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be final");
            assertEquals(int.class, Ninja.class.getDeclaredField("VITALITY").getType(), "The VITALITY field must be of int type");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be final");
            assertEquals(int.class, Ninja.class.getDeclaredField("INTELLIGENCE").getType(), "The INTELLIGENCE field must be of int type");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be final");
            assertEquals(int.class, Ninja.class.getDeclaredField("STRENGTH").getType(), "The STRENGTH field must be of int type");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be final");
            assertEquals(int.class, Ninja.class.getDeclaredField("AGILITY").getType(), "The AGILITY field must be of int type");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, Ninja.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPrivate(Ninja.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(Ninja.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(Ninja.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, Ninja.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
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
        assertEquals(numConstructors, Ninja.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredConstructor(String.class, Position.class, Empire.class).getModifiers()), "The constructor Ninja(String, Position, Empire) must be public");
            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Empire.class).getModifiers()), "The constructor Ninja(String, int, int, Position, int, int, int, int, int, int, Empire) must be public");
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
        assertEquals(numMethods, Ninja.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        try {
            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(Ninja.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(Ninja.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, Ninja.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must be boolean");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be public");
            assertFalse(Modifier.isStatic(Ninja.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be static");
            assertFalse(Modifier.isFinal(Ninja.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be final");
            assertEquals(String.class, Ninja.class.getDeclaredMethod("battleCry").getReturnType(), "The battleCry() method must be void");

            assertTrue(Modifier.isPublic(Ninja.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be public");
            assertFalse(Modifier.isStatic(Ninja.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be static");
            assertFalse(Modifier.isFinal(Ninja.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be final");
            assertEquals(String.class, Ninja.class.getDeclaredMethod("deathCry").getReturnType(), "The deathCry() method must be void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Player.class.isAssignableFrom(Ninja.class), "Ninja class must inherit from Player");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Ninja.class.getModifiers()), "Ninja class cannot be abstract");
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Creation default")
    void createNinjaDefaultTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("Ninja", position, Empire.JINNO);

            assertEquals("Ninja", ninja.getName());
            assertEquals(1, ninja.getLevel());
            assertEquals(180, ninja.getMaxHP());
            assertEquals(180, ninja.getCurrentHP());
            assertEquals(position, ninja.getPosition());
            assertEquals(Empire.JINNO, ninja.getEmpire());
            assertEquals(0, ninja.getCurrentGold());
            assertEquals(0, ninja.getCurrentExperience());
            assertEquals(4, ninja.getVitality());
            assertEquals(6, ninja.getIntelligence());
            assertEquals(3, ninja.getStrength());
            assertEquals(3, ninja.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation custom values")
    void createNinjaTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("Ninja", 90, 1000, position, 1000000, 55000000, 90, 10, 90, 50, Empire.JINNO);

            assertEquals("Ninja", ninja.getName());
            assertEquals(90, ninja.getLevel());
            assertEquals(1000, ninja.getMaxHP());
            assertEquals(1000, ninja.getCurrentHP());
            assertEquals(position, ninja.getPosition());
            assertEquals(Empire.JINNO, ninja.getEmpire());
            assertEquals(1000000, ninja.getCurrentGold());
            assertEquals(55000000, ninja.getCurrentExperience());
            assertEquals(90, ninja.getVitality());
            assertEquals(10, ninja.getIntelligence());
            assertEquals(90, ninja.getStrength());
            assertEquals(50, ninja.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid empire")
    void createNinjaInvalidEmpireTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);

            assertThrows(PlayerException.class, () -> {
                new Ninja("Ninja", position, null);
            });

            Ninja ninja = new Ninja("Ninja", position, Empire.JINNO);

            assertThrows(PlayerException.class, () -> {
                ninja.setEmpire(null);
            });
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Creation invalid stats")
    void createNinjaInvalidStatsTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("Ninja", 90, 1000, position, 1000000, 55000000, 91, -1, 90, 50, Empire.JINNO);

            assertEquals(90, ninja.getVitality());
            assertEquals(0, ninja.getIntelligence());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Creation invalid stats")
    void createNinjaInvalidGoldExpTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("Ninja", 90, 0, position, -1, -1, 90, 10, 90, 50, Empire.JINNO);

            assertEquals(1, ninja.getMaxHP());
            assertEquals(0, ninja.getCurrentHP());
            assertEquals(0, ninja.getCurrentGold());
            assertEquals(0, ninja.getCurrentExperience());

            ninja.setCurrentHP(-1);

            assertEquals(0, ninja.getCurrentHP());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Move")
    void moveNinjaTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("Ninja", position, Empire.JINNO);

            assertTrue(ninja.move(new Position(gameMap, 100, 60, 10)));
            assertEquals(new Position(gameMap, 100, 60, 10), ninja.getPosition());

            assertFalse(ninja.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 60, 10), ninja.getPosition());

            assertTrue(ninja.move(new Position(gameMap, 104, 65, 17)));
            assertEquals(new Position(gameMap, 104, 65, 17), ninja.getPosition());

            assertFalse(ninja.move(new Position(gameMap, 108, 71, 24)));
            assertEquals(new Position(gameMap, 104, 65, 17), ninja.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Battle cry")
    void battleCryNinjaTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("MyNinja", position, Empire.JINNO);

            assertEquals("MyNinja: Strike swift, strike silent!", ninja.battleCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Ninja object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Death cry")
    void deathCryNinjaTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Ninja ninja = new Ninja("MyNinja", position, Empire.JINNO);

            assertEquals("MyNinja: Silence, at last...", ninja.deathCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Ninja object: " + e.getMessage());
        }
    }

}
