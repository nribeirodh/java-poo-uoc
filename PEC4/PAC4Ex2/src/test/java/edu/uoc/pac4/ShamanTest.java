package edu.uoc.pac4;

import edu.uoc.pac4.exception.PlayerException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShamanTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 6;

        // Check number of fields
        assertEquals(numFields, Shaman.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("VITALITY").getModifiers()), "The field VITALITY must be final");
            assertEquals(int.class, Shaman.class.getDeclaredField("VITALITY").getType(), "The VITALITY field must be of int type");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("INTELLIGENCE").getModifiers()), "The field INTELLIGENCE must be final");
            assertEquals(int.class, Shaman.class.getDeclaredField("INTELLIGENCE").getType(), "The INTELLIGENCE field must be of int type");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("STRENGTH").getModifiers()), "The field STRENGTH must be final");
            assertEquals(int.class, Shaman.class.getDeclaredField("STRENGTH").getType(), "The STRENGTH field must be of int type");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("AGILITY").getModifiers()), "The field AGILITY must be final");
            assertEquals(int.class, Shaman.class.getDeclaredField("AGILITY").getType(), "The AGILITY field must be of int type");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, Shaman.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPrivate(Shaman.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(Shaman.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(Shaman.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, Shaman.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
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
        assertEquals(numConstructors, Shaman.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredConstructor(String.class, Position.class, Empire.class).getModifiers()), "The constructor Shaman(String, Position, Empire) must be public");
            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredConstructor(String.class, int.class, int.class, Position.class, int.class, int.class, int.class, int.class, int.class, int.class, Empire.class).getModifiers()), "The constructor Shaman(String, int, int, Position, int, int, int, int, int, int, Empire) must be public");
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
        assertEquals(numMethods, Shaman.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");

        try {
            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(Shaman.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(Shaman.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, Shaman.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must be boolean");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() must be public");
            assertFalse(Modifier.isStatic(Shaman.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be static");
            assertFalse(Modifier.isFinal(Shaman.class.getDeclaredMethod("battleCry").getModifiers()), "The method battleCry() cannot be final");
            assertEquals(String.class, Shaman.class.getDeclaredMethod("battleCry").getReturnType(), "The battleCry() method must be void");

            assertTrue(Modifier.isPublic(Shaman.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() must be public");
            assertFalse(Modifier.isStatic(Shaman.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be static");
            assertFalse(Modifier.isFinal(Shaman.class.getDeclaredMethod("deathCry").getModifiers()), "The method deathCry() cannot be final");
            assertEquals(String.class, Shaman.class.getDeclaredMethod("deathCry").getReturnType(), "The deathCry() method must be void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Player.class.isAssignableFrom(Shaman.class), "Shaman class must inherit from Player");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Shaman.class.getModifiers()), "Shaman class cannot be abstract");
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Creation default")
    void createShamanDefaultTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("Shaman", position, Empire.JINNO);

            assertEquals("Shaman", shaman.getName());
            assertEquals(1, shaman.getLevel());
            assertEquals(150, shaman.getMaxHP());
            assertEquals(150, shaman.getCurrentHP());
            assertEquals(position, shaman.getPosition());
            assertEquals(Empire.JINNO, shaman.getEmpire());
            assertEquals(0, shaman.getCurrentGold());
            assertEquals(0, shaman.getCurrentExperience());
            assertEquals(4, shaman.getVitality());
            assertEquals(6, shaman.getIntelligence());
            assertEquals(3, shaman.getStrength());
            assertEquals(3, shaman.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation custom values")
    void createShamanTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("Shaman", 90, 1000, position, 1000000, 55000000, 90, 10, 90, 50, Empire.JINNO);

            assertEquals("Shaman", shaman.getName());
            assertEquals(90, shaman.getLevel());
            assertEquals(1000, shaman.getMaxHP());
            assertEquals(1000, shaman.getCurrentHP());
            assertEquals(position, shaman.getPosition());
            assertEquals(Empire.JINNO, shaman.getEmpire());
            assertEquals(1000000, shaman.getCurrentGold());
            assertEquals(55000000, shaman.getCurrentExperience());
            assertEquals(90, shaman.getVitality());
            assertEquals(10, shaman.getIntelligence());
            assertEquals(90, shaman.getStrength());
            assertEquals(50, shaman.getAgility());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid empire")
    void createShamanInvalidEmpireTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);

            assertThrows(PlayerException.class, () -> {
                new Shaman("Shaman", position, null);
            });

            Shaman shaman = new Shaman("Shaman", position, Empire.JINNO);

            assertThrows(PlayerException.class, () -> {
                shaman.setEmpire(null);
            });
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Creation invalid stats")
    void createShamanInvalidStatsTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("Shaman", 90, 1000, position, 1000000, 55000000, 91, -1, 90, 50, Empire.JINNO);

            assertEquals(90, shaman.getVitality());
            assertEquals(0, shaman.getIntelligence());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Creation invalid stats")
    void createShamanInvalidGoldExpTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("Shaman", 90, 0, position, -1, -1, 90, 10, 90, 50, Empire.JINNO);

            assertEquals(1, shaman.getMaxHP());
            assertEquals(0, shaman.getCurrentHP());
            assertEquals(0, shaman.getCurrentGold());
            assertEquals(0, shaman.getCurrentExperience());

            shaman.setCurrentHP(-1);

            assertEquals(0, shaman.getCurrentHP());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Move")
    void moveShamanTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("Shaman", position, Empire.JINNO);

            assertTrue(shaman.move(new Position(gameMap, 100, 60, 10)));
            assertEquals(new Position(gameMap, 100, 60, 10), shaman.getPosition());

            assertFalse(shaman.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 60, 10), shaman.getPosition());

            assertTrue(shaman.move(new Position(gameMap, 104, 65, 17)));
            assertEquals(new Position(gameMap, 104, 65, 17), shaman.getPosition());

            assertFalse(shaman.move(new Position(gameMap, 108, 71, 24)));
            assertEquals(new Position(gameMap, 104, 65, 17), shaman.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Battle cry")
    void battleCryShamanTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("MyShaman", position, Empire.JINNO);

            assertEquals("MyShaman: Spirits guide us to victory!", shaman.battleCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Shaman object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Death cry")
    void deathCryShamanTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Shaman shaman = new Shaman("MyShaman", position, Empire.JINNO);

            assertEquals("MyShaman: My soul joins the ancestors...", shaman.deathCry());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the battleCry method of the Shaman object: " + e.getMessage());
        }
    }

}
