package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrcRebornTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 10;

        // Check number of fields
        assertEquals(numFields, OrcReborn.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("ID").getModifiers()), "The field ID must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("ID").getModifiers()), "The field ID must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("ID").getModifiers()), "The field ID must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("ID").getType(), "The ID field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be final");
            assertEquals(String.class, OrcReborn.class.getDeclaredField("NAME").getType(), "The NAME field must be of String type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("LEVEL").getType(), "The LEVEL field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("MIN_GOLD").getType(), "The MIN_GOLD field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("MAX_GOLD").getType(), "The MAX_GOLD field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("EXPERIENCE").getType(), "The EXPERIENCE field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("MIN_DAMAGE").getType(), "The MIN_DAMAGE field must be of int type");

            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be final");
            assertEquals(int.class, OrcReborn.class.getDeclaredField("MAX_DAMAGE").getType(), "The MAX_DAMAGE field must be of int type");

            assertTrue(Modifier.isPrivate(OrcReborn.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(OrcReborn.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(OrcReborn.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, OrcReborn.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
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
        assertEquals(numConstructors, OrcReborn.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredConstructor(Position.class, Enemy.class).getModifiers()), "The constructor OrcReborn(Position, Enemy) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 1;

        // Check number of methods
        assertEquals(numMethods, OrcReborn.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(OrcReborn.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(OrcReborn.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(OrcReborn.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, OrcReborn.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the method: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertFalse(TransCloneable.class.isAssignableFrom(OrcReborn.class), "OrcReborn class cannot implement TransCloneable interface");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Enemy.class.isAssignableFrom(OrcReborn.class), "OrcReborn class must inherit from Enemy");
    }

    @Test
    @Tag("sanity")
    @Order(6)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(OrcReborn.class.getModifiers()), "OrcReborn class cannot abstract");
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation")
    void createOrcRebornTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            OrcReborn orcReborn = new OrcReborn(position, null);

            assertEquals(102, orcReborn.getId());
            assertEquals("edu.uoc.pac4.Orc Reborn", orcReborn.getName());
            assertEquals(49, orcReborn.getLevel());
            assertEquals(260, orcReborn.getMaxHP());
            assertEquals(260, orcReborn.getCurrentHP());
            assertEquals(position, orcReborn.getPosition());
            assertEquals(250, orcReborn.getMinGold());
            assertEquals(350, orcReborn.getMaxGold());
            assertEquals(874, orcReborn.getExperience());
            assertEquals(40, orcReborn.getMinDamage());
            assertEquals(55, orcReborn.getMaxDamage());
            assertNull(orcReborn.getGroupLeader());
            assertFalse(orcReborn.isFarFromGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the OrcReborn object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid values")
    void createOrcRebornInvalidValuesTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            OrcReborn orcReborn = new OrcReborn(position, null);

            assertThrows(EntityException.class, () -> orcReborn.setName(null));
            assertThrows(EntityException.class, () -> orcReborn.setName(""));

            assertThrows(EntityException.class, () -> orcReborn.setLevel(0));
            assertThrows(EntityException.class, () -> orcReborn.setLevel(100));

            assertThrows(EntityException.class, () -> orcReborn.setPosition(null));

            orcReborn.setGold(-1, 100);
            assertEquals(0, orcReborn.getMinGold());
            assertEquals(100, orcReborn.getMaxGold());

            orcReborn.setGold(200, 150);
            assertEquals(200, orcReborn.getMinGold());
            assertEquals(200, orcReborn.getMaxGold());

            orcReborn.setExperience(-1);
            assertEquals(0, orcReborn.getExperience());

            orcReborn.setDamage(-1, 100);
            assertEquals(0, orcReborn.getMinDamage());
            assertEquals(100, orcReborn.getMaxDamage());

            orcReborn.setDamage(200, 150);
            assertEquals(200, orcReborn.getMinDamage());
            assertEquals(200, orcReborn.getMaxDamage());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the OrcReborn object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Is far from leader")
    void isFarFromLeaderTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            OrcReborn orcReborn = new OrcReborn(position, null);

            assertFalse(orcReborn.isFarFromGroupLeader());

            OrcReborn groupLeader = new OrcReborn(position, null);
            orcReborn.setGroupLeader(groupLeader);

            assertFalse(orcReborn.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 200, 100, 0));
            assertTrue(orcReborn.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 131, 88, 20));
            assertTrue(orcReborn.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 131, 87, 20));
            assertFalse(orcReborn.isFarFromGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the OrcReborn object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Move")
    void moveOrcRebornTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            OrcReborn orcReborn = new OrcReborn(position, null);

            assertTrue(orcReborn.move(new Position(gameMap, 100, 60, 10)));
            assertEquals(new Position(gameMap, 100, 60, 10), orcReborn.getPosition());

            assertFalse(orcReborn.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 60, 10), orcReborn.getPosition());

            assertTrue(orcReborn.move(new Position(gameMap, 104, 65, 17)));
            assertEquals(new Position(gameMap, 104, 65, 17), orcReborn.getPosition());

            assertFalse(orcReborn.move(new Position(gameMap, 108, 71, 24)));
            assertEquals(new Position(gameMap, 104, 65, 17), orcReborn.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the OrcReborn object: " + e.getMessage());
        }
    }
}
