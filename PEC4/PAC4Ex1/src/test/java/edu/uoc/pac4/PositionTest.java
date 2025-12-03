package edu.uoc.pac4;

import edu.uoc.pac4.exception.*;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 4;

        // Check attribute fields
        assertEquals(numFields, Position.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPrivate(Position.class.getDeclaredField("x").getModifiers()), "The attribute x must be private");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredField("x").getModifiers()), "The attribute x must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredField("x").getModifiers()), "The attribute x must not be final");
            assertEquals(int.class, Position.class.getDeclaredField("x").getType(), "The x attribute must be of int type");

            assertTrue(Modifier.isPrivate(Position.class.getDeclaredField("y").getModifiers()), "The attribute y must be private");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredField("y").getModifiers()), "The attribute y must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredField("y").getModifiers()), "The attribute y must not be final");
            assertEquals(int.class, Position.class.getDeclaredField("y").getType(), "The y attribute must be of int type");

            assertTrue(Modifier.isPrivate(Position.class.getDeclaredField("z").getModifiers()), "The attribute z must be private");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredField("z").getModifiers()), "The attribute z must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredField("z").getModifiers()), "The attribute z must not be final");
            assertEquals(int.class, Position.class.getDeclaredField("z").getType(), "The z attribute must be of int type");

            assertTrue(Modifier.isPrivate(Position.class.getDeclaredField("gameMap").getModifiers()), "The attribute gameMap must be private");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredField("gameMap").getModifiers()), "The attribute gameMap must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredField("gameMap").getModifiers()), "The attribute gameMap must not be final");
            assertEquals(GameMap.class, Position.class.getDeclaredField("gameMap").getType(), "The gameMap attribute must be of GameMap type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check constructors
        assertEquals(numConstructors, Position.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(Position.class.getDeclaredConstructor(GameMap.class, int.class, int.class, int.class).getModifiers()), "The constructor Position(GameMap, int, int, int) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 11;

        // Check attribute fields
        assertEquals(numMethods, Position.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("getGameMap").getModifiers()), "The getGameMap method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("getGameMap").getModifiers()), "The getGameMap method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("getGameMap").getModifiers()), "The getGameMap method must not be final");
            assertEquals(GameMap.class, Position.class.getDeclaredMethod("getGameMap").getReturnType(), "The getGameMap method must return a GameMap type");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("setGameMap", GameMap.class).getModifiers()), "The setGameMap method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("setGameMap", GameMap.class).getModifiers()), "The setGameMap method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("setGameMap", GameMap.class).getModifiers()), "The setGameMap method must not be final");
            assertEquals(void.class, Position.class.getDeclaredMethod("setGameMap", GameMap.class).getReturnType(), "The setGameMap method must return void");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("getX").getModifiers()), "The getX method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("getX").getModifiers()), "The getX method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("getX").getModifiers()), "The getX method must not be final");
            assertEquals(int.class, Position.class.getDeclaredMethod("getX").getReturnType(), "The getX method must return an int type");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("setX", int.class).getModifiers()), "The setX method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("setX", int.class).getModifiers()), "The setX method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("setX", int.class).getModifiers()), "The setX method must not be final");
            assertEquals(void.class, Position.class.getDeclaredMethod("setX", int.class).getReturnType(), "The setX method must return void");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("getY").getModifiers()), "The getY method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("getY").getModifiers()), "The getY method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("getY").getModifiers()), "The getY method must not be final");
            assertEquals(int.class, Position.class.getDeclaredMethod("getY").getReturnType(), "The getY method must return an int type");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("setY", int.class).getModifiers()), "The setY method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("setY", int.class).getModifiers()), "The setY method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("setY", int.class).getModifiers()), "The setY method must not be final");
            assertEquals(void.class, Position.class.getDeclaredMethod("setY", int.class).getReturnType(), "The setY method must return void");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("getZ").getModifiers()), "The getZ method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("getZ").getModifiers()), "The getZ method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("getZ").getModifiers()), "The getZ method must not be final");
            assertEquals(int.class, Position.class.getDeclaredMethod("getZ").getReturnType(), "The getZ method must return an int type");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("setZ", int.class).getModifiers()), "The setZ method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("setZ", int.class).getModifiers()), "The setZ method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("setZ", int.class).getModifiers()), "The setZ method must not be final");
            assertEquals(void.class, Position.class.getDeclaredMethod("setZ", int.class).getReturnType(), "The setZ method must return void");

            assertTrue(Modifier.isPublic(Position.class.getDeclaredMethod("euclideanDistance", Position.class).getModifiers()), "The euclideanDistance method must be public");
            assertFalse(Modifier.isStatic(Position.class.getDeclaredMethod("euclideanDistance", Position.class).getModifiers()), "The euclideanDistance method must not be static");
            assertFalse(Modifier.isFinal(Position.class.getDeclaredMethod("euclideanDistance", Position.class).getModifiers()), "The euclideanDistance method must not be final");
            assertEquals(double.class, Position.class.getDeclaredMethod("euclideanDistance", Position.class).getReturnType(), "The euclideanDistance method must return a double type");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test - Position creation")
    void createPositionTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position = new Position(gameMap, 100, 50, 0);

            assertEquals(gameMap, position.getGameMap());
            assertEquals(100, position.getX());
            assertEquals(50, position.getY());
            assertEquals(0, position.getZ());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the creation of the Position object: " + e.getMessage());
        }

        PositionException exception = assertThrows(PositionException.class, () -> new Position(null, 100, 50, 0));
        assertEquals(PositionException.MAP_NULL, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), -1, 50, 0));
        assertEquals(PositionException.INVALID_X, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), 1025, 50, 0));
        assertEquals(PositionException.OUT_OF_BOUNDS_X, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), 100, -1, 0));
        assertEquals(PositionException.INVALID_Y, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), 100, 1537, 0));
        assertEquals(PositionException.OUT_OF_BOUNDS_Y, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), 100, 50, -1));
        assertEquals(PositionException.INVALID_Z, exception.getMessage());

        exception = assertThrows(PositionException.class, () -> new Position(new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY), 100, 50, 513));
        assertEquals(PositionException.OUT_OF_BOUNDS_Z, exception.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Test - Getters and setters")
    void gettersAndSettersTest() {
        try {
            GameMap gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            GameMap gameMap2 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            Position position = new Position(gameMap1, 100, 50, 0);

            position.setGameMap(gameMap2);
            assertEquals(gameMap2, position.getGameMap());

            position.setX(1002);
            assertEquals(1002, position.getX());

            position.setY(584);
            assertEquals(584, position.getY());

            position.setZ(89);
            assertEquals(89, position.getZ());

            PositionException exception = assertThrows(PositionException.class, () -> position.setGameMap(null));
            assertEquals(PositionException.MAP_NULL, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setX(-1));
            assertEquals(PositionException.INVALID_X, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setX(1537));
            assertEquals(PositionException.OUT_OF_BOUNDS_X, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setY(-1));
            assertEquals(PositionException.INVALID_Y, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setY(1537));
            assertEquals(PositionException.OUT_OF_BOUNDS_Y, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setZ(-1));
            assertEquals(PositionException.INVALID_Z, exception.getMessage());

            exception = assertThrows(PositionException.class, () -> position.setZ(513));
            assertEquals(PositionException.OUT_OF_BOUNDS_Z, exception.getMessage());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the getters and setters of the Position object: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @DisplayName("Test - Euclidean distance")
    void euclideanDistanceTest() {
        try {
            GameMap gameMap = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            Position position1 = new Position(gameMap, 100, 50, 0);
            Position position2 = new Position(gameMap, 200, 100, 0);

            assertEquals(111.80, Math.round(position1.euclideanDistance(position2) * 100.0) / 100.0);

            position2.setX(400);
            position2.setY(200);
            position2.setZ(150);

            assertEquals(367.42, Math.round(position1.euclideanDistance(position2) * 100.0) / 100.0);
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the euclideanDistance method of the Position object: " + e.getMessage());
        }
    }

}
