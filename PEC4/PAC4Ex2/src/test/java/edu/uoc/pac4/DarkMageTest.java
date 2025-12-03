package edu.uoc.pac4;

import edu.uoc.pac4.exception.PlayerException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DarkMageTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 6;

        // Check number of fields
        assertEquals(numFields, DarkMage.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be final");
            assertEquals(int.class, DarkMage.class.getDeclaredField("VITALITY").getType(), "The VITALITY field must be of int type");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be final");
            assertEquals(int.class, DarkMage.class.getDeclaredField("INTELLIGENCE").getType(), "The INTELLIGENCE field must be of int type");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be final");
            assertEquals(int.class, DarkMage.class.getDeclaredField("STRENGTH").getType(), "The STRENGTH field must be of int type");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be final");
            assertEquals(int.class, DarkMage.class.getDeclaredField("AGILITY").getType(), "The AGILITY field must be of int type");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, DarkMage.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPrivate(DarkMage.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(DarkMage.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(DarkMage.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, DarkMage.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
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
        assertEquals(numConstructors, DarkMage.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredConstructor(String.class, Position.class, Empire.class).getModifiers()), "The constructor DarkMage(String, Position, Empire) must be public");
            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Empire.class).getModifiers()), "The constructor DarkMage(String, int, int, Position, int, int, int, int, int, int, Empire) must be public");
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
        assertEquals(numMethods, DarkMage.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        try {
            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(DarkMage.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(DarkMage.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, DarkMage.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must be boolean");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be public");
            assertFalse(Modifier.isStatic(DarkMage.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be static");
            assertFalse(Modifier.isFinal(DarkMage.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be final");
            assertEquals(String.class, DarkMage.class.getDeclaredMethod("battleCry").getReturnType(), "The battleCry() method must be void");

            assertTrue(Modifier.isPublic(DarkMage.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be public");
            assertFalse(Modifier.isStatic(DarkMage.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be static");
            assertFalse(Modifier.isFinal(DarkMage.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be final");
            assertEquals(String.class, DarkMage.class.getDeclaredMethod("deathCry").getReturnType(), "The deathCry() method must be void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Player.class.isAssignableFrom(DarkMage.class), "DarkMage class must inherit from Player");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(DarkMage.class.getModifiers()), "DarkMage class cannot be abstract");
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Creation default")
    void createDarkMageDefaultTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("DarkMage", position, Empire.JINNO);

            assertEquals("DarkMage", darkMage.getName());
            assertEquals(1, darkMage.getLevel());
            assertEquals(200, darkMage.getMaxHP());
            assertEquals(200, darkMage.getCurrentHP());
            assertEquals(position, darkMage.getPosition());
            assertEquals(Empire.JINNO, darkMage.getEmpire());
            assertEquals(0, darkMage.getCurrentGold());
            assertEquals(0, darkMage.getCurrentExperience());
            assertEquals(3, darkMage.getVitality());
            assertEquals(5, darkMage.getIntelligence());
            assertEquals(5, darkMage.getStrength());
            assertEquals(3, darkMage.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation custom values")
    void createDarkMageTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("DarkMage", 90, 1000, position, 1000000, 55000000, 90, 10, 90, 50, Empire.JINNO);

            assertEquals("DarkMage", darkMage.getName());
            assertEquals(90, darkMage.getLevel());
            assertEquals(1000, darkMage.getMaxHP());
            assertEquals(1000, darkMage.getCurrentHP());
            assertEquals(position, darkMage.getPosition());
            assertEquals(Empire.JINNO, darkMage.getEmpire());
            assertEquals(1000000, darkMage.getCurrentGold());
            assertEquals(55000000, darkMage.getCurrentExperience());
            assertEquals(90, darkMage.getVitality());
            assertEquals(10, darkMage.getIntelligence());
            assertEquals(90, darkMage.getStrength());
            assertEquals(50, darkMage.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid empire")
    void createDarkMageInvalidEmpireTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);

            assertThrows(PlayerException.class, () -> {
                new DarkMage("DarkMage", position, null);
            });

            DarkMage darkMage = new DarkMage("DarkMage", position, Empire.JINNO);

            assertThrows(PlayerException.class, () -> {
                darkMage.setEmpire(null);
            });
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Creation invalid stats")
    void createDarkMageInvalidStatsTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("DarkMage", 90, 1000, position, 1000000, 55000000, 91, -1, 90, 50, Empire.JINNO);

            assertEquals(90, darkMage.getVitality());
            assertEquals(0, darkMage.getIntelligence());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Creation invalid stats")
    void createDarkMageInvalidGoldExpTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("DarkMage", 90, 0, position, -1, -1, 90, 10, 90, 50, Empire.JINNO);

            assertEquals(1, darkMage.getMaxHP());
            assertEquals(0, darkMage.getCurrentHP());
            assertEquals(0, darkMage.getCurrentGold());
            assertEquals(0, darkMage.getCurrentExperience());

            darkMage.setCurrentHP(-1);

            assertEquals(0, darkMage.getCurrentHP());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Move")
    void moveDarkMageTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("DarkMage", position, Empire.JINNO);

            assertTrue(darkMage.move(new Position(gameMap, 100, 62, 10)));
            assertEquals(new Position(gameMap, 100, 62, 10), darkMage.getPosition());

            assertFalse(darkMage.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 62, 10), darkMage.getPosition());

            assertTrue(darkMage.move(new Position(gameMap, 107, 69, 16)));
            assertEquals(new Position(gameMap, 107, 69, 16), darkMage.getPosition());

            assertFalse(darkMage.move(new Position(gameMap, 114, 76, 23)));
            assertEquals(new Position(gameMap, 107, 69, 16), darkMage.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Battle cry")
    void battleCryDarkMageTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("MyDarkMage", position, Empire.JINNO);

            assertEquals("MyDarkMage: Let the darkness reign!", darkMage.battleCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the DarkMage object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Death cry")
    void deathCryDarkMageTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            DarkMage darkMage = new DarkMage("MyDarkMage", position, Empire.JINNO);

            assertEquals("MyDarkMage: The dark arts will live on...", darkMage.deathCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the DarkMage object: " + e.getMessage());
        }
    }

}
