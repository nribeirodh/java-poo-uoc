package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrcTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 10;

        // Check number of fields
        assertEquals(numFields, Orc.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields");

        try {
            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("ID").getModifiers()), "The field ID must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("ID").getModifiers()), "The field ID must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("ID").getModifiers()), "The field ID must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("ID").getType(), "The ID field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("NAME").getModifiers()), "The field NAME must be final");
            assertEquals(String.class, Orc.class.getDeclaredField("NAME").getType(), "The NAME field must be of String type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("LEVEL").getModifiers()), "The field LEVEL must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("LEVEL").getType(), "The LEVEL field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MAX_HP").getModifiers()), "The field MAX_HP must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("MAX_HP").getType(), "The MAX_HP field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MIN_GOLD").getModifiers()), "The field MIN_GOLD must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("MIN_GOLD").getType(), "The MIN_GOLD field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MAX_GOLD").getModifiers()), "The field MAX_GOLD must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("MAX_GOLD").getType(), "The MAX_GOLD field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("EXPERIENCE").getModifiers()), "The field EXPERIENCE must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("EXPERIENCE").getType(), "The EXPERIENCE field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MIN_DAMAGE").getModifiers()), "The field MIN_DAMAGE must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("MIN_DAMAGE").getType(), "The MIN_DAMAGE field must be of int type");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MAX_DAMAGE").getModifiers()), "The field MAX_DAMAGE must be final");
            assertEquals(int.class, Orc.class.getDeclaredField("MAX_DAMAGE").getType(), "The MAX_DAMAGE field must be of int type");

            assertTrue(Modifier.isPrivate(Orc.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be public");
            assertTrue(Modifier.isStatic(Orc.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be static");
            assertTrue(Modifier.isFinal(Orc.class.getDeclaredField("MAX_STEP").getModifiers()), "The field MAX_STEP must be final");
            assertEquals(double.class, Orc.class.getDeclaredField("MAX_STEP").getType(), "The MAX_STEP field must be of int type");
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
        assertEquals(numConstructors, Orc.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(Orc.class.getDeclaredConstructor(Position.class, Enemy.class).getModifiers()), "The constructor edu.uoc.pac4.Orc(Position, Enemy) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 5;

        // Check number of methods
        assertEquals(numMethods, Orc.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Orc.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) must be public");
            assertFalse(Modifier.isStatic(Orc.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be static");
            assertFalse(Modifier.isFinal(Orc.class.getDeclaredMethod("move", Position.class).getModifiers()), "The method move(Position) cannot be final");
            assertEquals(boolean.class, Orc.class.getDeclaredMethod("move", Position.class).getReturnType(), "The move(Position) method must return void");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredMethod("clone").getModifiers()), "The method clone() must be public");
            assertFalse(Modifier.isStatic(Orc.class.getDeclaredMethod("clone").getModifiers()), "The method clone() cannot be static");
            assertFalse(Modifier.isFinal(Orc.class.getDeclaredMethod("clone").getModifiers()), "The method clone() cannot be final");
            assertEquals(Enemy.class, Orc.class.getDeclaredMethod("clone").getReturnType(), "The clone() method must return an edu.uoc.pac4.Orc object");

            assertTrue(Modifier.isPublic(Orc.class.getDeclaredMethod("transClone").getModifiers()), "The method transClone() must be public");
            assertFalse(Modifier.isStatic(Orc.class.getDeclaredMethod("transClone").getModifiers()), "The method transClone() cannot be static");
            assertFalse(Modifier.isFinal(Orc.class.getDeclaredMethod("transClone").getModifiers()), "The method transClone() cannot be final");
            assertEquals(OrcReborn.class, Orc.class.getDeclaredMethod("transClone").getReturnType(), "The transClone() method must return an OrcReborn object");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the method: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertTrue(TransCloneable.class.isAssignableFrom(Orc.class), "edu.uoc.pac4.Orc class must implement TransCloneable interface");
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Enemy.class.isAssignableFrom(Orc.class), "edu.uoc.pac4.Orc class must inherit from Enemy");
    }

    @Test
    @Tag("sanity")
    @Order(6)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Orc.class.getModifiers()), "edu.uoc.pac4.Orc class cannot abstract");
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Creation")
    void createOrcTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Orc orc = new Orc(position, null);

            assertEquals(101, orc.getId());
            assertEquals("edu.uoc.pac4.Orc", orc.getName());
            assertEquals(46, orc.getLevel());
            assertEquals(190, orc.getMaxHP());
            assertEquals(190, orc.getCurrentHP());
            assertEquals(position, orc.getPosition());
            assertEquals(150, orc.getMinGold());
            assertEquals(200, orc.getMaxGold());
            assertEquals(488, orc.getExperience());
            assertEquals(10, orc.getMinDamage());
            assertEquals(15, orc.getMaxDamage());
            assertNull(orc.getGroupLeader());
            assertFalse(orc.isFarFromGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the edu.uoc.pac4.Orc object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Creation invalid values")
    void createOrcInvalidValuesTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 10);
            Orc orc = new Orc(position, null);

            assertThrows(EntityException.class, () -> orc.setName(null));
            assertThrows(EntityException.class, () -> orc.setName(""));

            assertThrows(EntityException.class, () -> orc.setLevel(0));
            assertThrows(EntityException.class, () -> orc.setLevel(100));

            assertThrows(EntityException.class, () -> orc.setPosition(null));

            orc.setGold(-1, 100);
            assertEquals(0, orc.getMinGold());
            assertEquals(100, orc.getMaxGold());

            orc.setGold(200, 150);
            assertEquals(200, orc.getMinGold());
            assertEquals(200, orc.getMaxGold());

            orc.setExperience(-1);
            assertEquals(0, orc.getExperience());

            orc.setDamage(-1, 100);
            assertEquals(0, orc.getMinDamage());
            assertEquals(100, orc.getMaxDamage());

            orc.setDamage(200, 150);
            assertEquals(200, orc.getMinDamage());
            assertEquals(200, orc.getMaxDamage());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the edu.uoc.pac4.Orc object: " + e.getMessage());
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
            Orc orc = new Orc(position, null);

            assertFalse(orc.isFarFromGroupLeader());

            Orc groupLeader = new Orc(position, null);
            orc.setGroupLeader(groupLeader);

            assertFalse(orc.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 200, 100, 0));
            assertTrue(orc.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 131, 88, 20));
            assertTrue(orc.isFarFromGroupLeader());

            groupLeader.setPosition(new Position(gameMap, 131, 87, 20));
            assertFalse(orc.isFarFromGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the edu.uoc.pac4.Orc object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Move")
    void moveOrcTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 53, 10);
            Orc orc = new Orc(position, null);

            assertTrue(orc.move(new Position(gameMap, 100, 60, 10)));
            assertEquals(new Position(gameMap, 100, 60, 10), orc.getPosition());

            assertFalse(orc.move(new Position(gameMap, 200, 100, 0)));
            assertEquals(new Position(gameMap, 100, 60, 10), orc.getPosition());

            assertTrue(orc.move(new Position(gameMap, 105, 64, 11)));
            assertEquals(new Position(gameMap, 105, 64, 11), orc.getPosition());

            assertFalse(orc.move(new Position(gameMap, 108, 69, 15)));
            assertEquals(new Position(gameMap, 105, 64, 11), orc.getPosition());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the move method of the edu.uoc.pac4.Orc object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Clone")
    void cloneOrcTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 53, 10);
            Orc groupLeader = new Orc(position, null);
            Orc orc = new Orc(position, groupLeader);

            Orc clone = (Orc) orc.clone();

            assertEquals(orc.getId(), clone.getId());
            assertEquals(orc.getName(), clone.getName());
            assertEquals(orc.getLevel(), clone.getLevel());
            assertEquals(orc.getMaxHP(), clone.getMaxHP());
            assertEquals(orc.getCurrentHP(), clone.getCurrentHP());
            assertEquals(orc.getPosition(), clone.getPosition());
            assertEquals(orc.getMinGold(), clone.getMinGold());
            assertEquals(orc.getMaxGold(), clone.getMaxGold());
            assertEquals(orc.getExperience(), clone.getExperience());
            assertEquals(orc.getMinDamage(), clone.getMinDamage());
            assertEquals(orc.getMaxDamage(), clone.getMaxDamage());

            assertEquals(orc.getPosition(), clone.getPosition());
            assertNotSame(orc.getPosition(), clone.getPosition());

            assertEquals(orc.getGroupLeader(), clone.getGroupLeader());
            assertSame(orc.getGroupLeader(), clone.getGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the clone method of the edu.uoc.pac4.Orc object: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - TransClone")
    void transCloneOrcTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 53, 10);
            Orc groupLeader = new Orc(position, null);
            Orc orc = new Orc(position, groupLeader);

            OrcReborn transClone = orc.transClone();

            assertEquals(OrcReborn.ID, transClone.getId());
            assertEquals(OrcReborn.NAME, transClone.getName());
            assertEquals(OrcReborn.LEVEL, transClone.getLevel());
            assertEquals(OrcReborn.MAX_HP, transClone.getMaxHP());
            assertEquals(OrcReborn.MIN_GOLD, transClone.getMinGold());
            assertEquals(OrcReborn.MAX_GOLD, transClone.getMaxGold());
            assertEquals(OrcReborn.EXPERIENCE, transClone.getExperience());
            assertEquals(OrcReborn.MIN_DAMAGE, transClone.getMinDamage());
            assertEquals(OrcReborn.MAX_DAMAGE, transClone.getMaxDamage());

            assertEquals(orc.getPosition(), transClone.getPosition());
            assertNotSame(orc.getPosition(), transClone.getPosition());

            assertEquals(orc.getGroupLeader(), transClone.getGroupLeader());
            assertSame(orc.getGroupLeader(), transClone.getGroupLeader());

            transClone = groupLeader.transClone();

            assertEquals(groupLeader, transClone.getGroupLeader());
            assertSame(groupLeader, transClone.getGroupLeader());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the transClone method of the edu.uoc.pac4.Orc object: " + e.getMessage());
        }
    }
}
