package edu.uoc.pac4;

import edu.uoc.pac4.exception.GameMapException;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        int numFields = 6;

        // Check attribute fields
        assertEquals(numFields, GameMap.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("gameMapId").getModifiers()), "The attribute gameMapId must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("gameMapId").getModifiers()), "The attribute gameMapId cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("gameMapId").getModifiers()), "The attribute gameMapId cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredField("gameMapId").getType(), "The gameMapId attribute must be of int type");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("name").getModifiers()), "The attribute name must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("name").getModifiers()), "The attribute name cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("name").getModifiers()), "The attribute name cannot be final");
            assertEquals(String.class, GameMap.class.getDeclaredField("name").getType(), "The name attribute must be of String type");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("width").getModifiers()), "The attribute width must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("width").getModifiers()), "The attribute width cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("width").getModifiers()), "The attribute width cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredField("width").getType(), "The width attribute must be of int type");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("height").getModifiers()), "The attribute height must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("height").getModifiers()), "The attribute height cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("height").getModifiers()), "The attribute height cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredField("height").getType(), "The height attribute must be of int type");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("depth").getModifiers()), "The attribute depth must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("depth").getModifiers()), "The attribute depth cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("depth").getModifiers()), "The attribute depth cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredField("depth").getType(), "The depth attribute must be of int type");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredField("gameMapType").getModifiers()), "The attribute gameMapType must be private");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredField("gameMapType").getModifiers()), "The attribute gameMapType cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredField("gameMapType").getModifiers()), "The attribute gameMapType cannot be final");
            assertEquals(GameMapType.class, GameMap.class.getDeclaredField("gameMapType").getType(), "The gameMapType attribute must be of GameMapType type");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, GameMap.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(GameMap.class.getConstructor(int.class, String.class, int.class, int.class, int.class, GameMapType.class).getModifiers()), "The constructor GameMap(int, String, int, int, int) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 14;

        // Check number of methods
        assertEquals(numMethods, GameMap.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getGameMapId").getModifiers()), "The getGameMapId method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getGameMapId").getModifiers()), "The getGameMapId method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getGameMapId").getModifiers()), "The getGameMapId method cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredMethod("getGameMapId").getReturnType(), "The getGameMapId method must return an int");

            assertTrue(Modifier.isPrivate(GameMap.class.getDeclaredMethod("setGameMapId", int.class).getModifiers()), "The setGameMapId method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("setGameMapId", int.class).getModifiers()), "The setGameMapId method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("setGameMapId", int.class).getModifiers()), "The setGameMapId method cannot be final");
            assertEquals(void.class, GameMap.class.getDeclaredMethod("setGameMapId", int.class).getReturnType(), "The setGameMapId method must return void");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getName").getModifiers()), "The getName method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getName").getModifiers()), "The getName method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getName").getModifiers()), "The getName method cannot be final");
            assertEquals(String.class, GameMap.class.getDeclaredMethod("getName").getReturnType(), "The getName method must return a String");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("setName", String.class).getModifiers()), "The setName method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("setName", String.class).getModifiers()), "The setName method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("setName", String.class).getModifiers()), "The setName method cannot be final");
            assertEquals(void.class, GameMap.class.getDeclaredMethod("setName", String.class).getReturnType(), "The setName method must return void");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getWidth").getModifiers()), "The getWidth method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getWidth").getModifiers()), "The getWidth method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getWidth").getModifiers()), "The getWidth method cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredMethod("getWidth").getReturnType(), "The getWidth method must return an int");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("setWidth", int.class).getModifiers()), "The setWidth method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("setWidth", int.class).getModifiers()), "The setWidth method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("setWidth", int.class).getModifiers()), "The setWidth method cannot be final");
            assertEquals(void.class, GameMap.class.getDeclaredMethod("setWidth", int.class).getReturnType(), "The setWidth method must return void");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getHeight").getModifiers()), "The getHeight method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getHeight").getModifiers()), "The getHeight method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getHeight").getModifiers()), "The getHeight method cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredMethod("getHeight").getReturnType(), "The getHeight method must return an int");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("setHeight", int.class).getModifiers()), "The setHeight method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("setHeight", int.class).getModifiers()), "The setHeight method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("setHeight", int.class).getModifiers()), "The setHeight method cannot be final");
            assertEquals(void.class, GameMap.class.getDeclaredMethod("setHeight", int.class).getReturnType(), "The setHeight method must return void");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getDepth").getModifiers()), "The getDepth method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getDepth").getModifiers()), "The getDepth method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getDepth").getModifiers()), "The getDepth method cannot be final");
            assertEquals(int.class, GameMap.class.getDeclaredMethod("getDepth").getReturnType(), "The getDepth method must return an int");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("setDepth", int.class).getModifiers()), "The setDepth method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("setDepth", int.class).getModifiers()), "The setDepth method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("setDepth", int.class).getModifiers()), "The setDepth method cannot be final");
            assertEquals(void.class, GameMap.class.getDeclaredMethod("setDepth", int.class).getReturnType(), "The setDepth method must return void");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getGameMapType").getModifiers()), "The getGameMapType method must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getGameMapType").getModifiers()), "The getGameMapType method cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getGameMapType").getModifiers()), "The getGameMapType method cannot be final");
            assertEquals(GameMapType.class, GameMap.class.getDeclaredMethod("getGameMapType").getReturnType(), "The getGameMapType method must return a GameMapType");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test - Game map creation")
    void createGameMapTest() {
        GameMap gameMap1 = null;
        GameMap gameMap2 = null;
        GameMap gameMap3 = null;

        try {
            gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            gameMap2 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            gameMap3 = new GameMap(3, "Doyyumhwan", 1536, 1536, 1024, GameMapType.VOLCANO);
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }

        assertEquals(1, gameMap1.getGameMapId(), "The game map ID must be 1");
        assertEquals("Area Joan", gameMap1.getName(), "The game map name must be 'Area Joan'");
        assertEquals(1024, gameMap1.getWidth(), "The game map width must be 1024");
        assertEquals(1536, gameMap1.getHeight(), "The game map height must be 1536");
        assertEquals(512, gameMap1.getDepth(), "The game map depth must be 512");
        assertEquals(GameMapType.CITY, gameMap1.getGameMapType(), "The game map type must be CITY");

        assertEquals(2, gameMap2.getGameMapId(), "The game map ID must be 2");
        assertEquals("Valley of Seungryong", gameMap2.getName(), "The game map name must be 'Valley of Seungryong'");
        assertEquals(1536, gameMap2.getWidth(), "The game map width must be 1536");
        assertEquals(1536, gameMap2.getHeight(), "The game map height must be 1536");
        assertEquals(512, gameMap2.getDepth(), "The game map depth must be 512");
        assertEquals(GameMapType.VALLEY, gameMap2.getGameMapType(), "The game map type must be VALLEY");

        assertEquals(3, gameMap3.getGameMapId(), "The game map ID must be 3");
        assertEquals("Doyyumhwan", gameMap3.getName(), "The game map name must be 'Doyyumhwan'");
        assertEquals(1536, gameMap3.getWidth(), "The game map width must be 1536");
        assertEquals(1536, gameMap3.getHeight(), "The game map height must be 1536");
        assertEquals(1024, gameMap3.getDepth(), "The game map depth must be 1024");
        assertEquals(GameMapType.VOLCANO, gameMap3.getGameMapType(), "The game map type must be VOLCANO");

        try {
            GameMapException exception = assertThrows(GameMapException.class, () -> new GameMap(0, "Area Joan", 1024, 1536, 512, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_GAME_MAP_ID, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, null, 1024, 1536, 512, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_NAME, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, "", 1024, 1536, 512, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_NAME, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, "Area Joan", 0, 1536, 512, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_WIDTH, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, "Area Joan", 1024, 0, 512, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_HEIGHT, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, "Area Joan", 1024, 1536, 0, GameMapType.CITY));
            assertEquals(GameMapException.INVALID_DEPTH, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> new GameMap(1, "Area Joan", 1024, 1536, 512, null));
            assertEquals(GameMapException.MAP_TYPE_NULL, exception.getMessage());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @DisplayName("Test - Getters and setters")
    void gettersAndSettersTest() {
        GameMap gameMap1 = null;
        GameMap gameMap2 = null;
        GameMap gameMap3 = null;

        try {
            gameMap1 = new GameMap(1, "Area Joan", 1024, 1536, 512, GameMapType.CITY);
            gameMap2 = new GameMap(2, "Valley of Seungryong", 1536, 1536, 512, GameMapType.VALLEY);
            gameMap3 = new GameMap(3, "Doyyumhwan", 1536, 1536, 1024, GameMapType.VOLCANO);
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the constructors: " + e.getMessage());
        }

        try {
            gameMap1.setName("Area Bakra");
            gameMap1.setWidth(2048);
            gameMap1.setHeight(1024);
            gameMap1.setDepth(256);
            gameMap1.setGameMapType(GameMapType.DESERT);

            gameMap2.setName("Valley of Seungryong");
            gameMap2.setWidth(1024);
            gameMap2.setHeight(2048);
            gameMap2.setDepth(512);
            gameMap2.setGameMapType(GameMapType.FOREST);

            gameMap3.setName("Doyyumhwan");
            gameMap3.setWidth(2048);
            gameMap3.setHeight(2048);
            gameMap3.setDepth(1024);
            gameMap3.setGameMapType(GameMapType.MOUNTAIN);
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the setters: " + e.getMessage());
        }

        assertEquals(1, gameMap1.getGameMapId(), "The game map ID must be 1");
        assertEquals("Area Bakra", gameMap1.getName(), "The game map name must be 'Area Bakra'");
        assertEquals(2048, gameMap1.getWidth(), "The game map width must be 2048");
        assertEquals(1024, gameMap1.getHeight(), "The game map height must be 1024");
        assertEquals(256, gameMap1.getDepth(), "The game map depth must be 256");
        assertEquals(GameMapType.DESERT, gameMap1.getGameMapType(), "The game map type must be DESERT");

        assertEquals(2, gameMap2.getGameMapId(), "The game map ID must be 2");
        assertEquals("Valley of Seungryong", gameMap2.getName(), "The game map name must be 'Valley of Seungryong'");
        assertEquals(1024, gameMap2.getWidth(), "The game map width must be 1024");
        assertEquals(2048, gameMap2.getHeight(), "The game map height must be 2048");
        assertEquals(512, gameMap2.getDepth(), "The game map depth must be 512");
        assertEquals(GameMapType.FOREST, gameMap2.getGameMapType(), "The game map type must be FOREST");

        assertEquals(3, gameMap3.getGameMapId(), "The game map ID must be 3");
        assertEquals("Doyyumhwan", gameMap3.getName(), "The game map name must be 'Doyyumhwan'");
        assertEquals(2048, gameMap3.getWidth(), "The game map width must be 2048");
        assertEquals(2048, gameMap3.getHeight(), "The game map height must be 2048");
        assertEquals(1024, gameMap3.getDepth(), "The game map depth must be 1024");
        assertEquals(GameMapType.MOUNTAIN, gameMap3.getGameMapType(), "The game map type must be MOUNTAIN");

        try {
            GameMap gameMap4 = new GameMap(4, "Area Joan", 1024, 1536, 512, GameMapType.CITY);

            GameMapException exception = assertThrows(GameMapException.class, () -> gameMap4.setName(null));
            assertEquals(GameMapException.INVALID_NAME, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> gameMap4.setName(""));
            assertEquals(GameMapException.INVALID_NAME, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> gameMap4.setWidth(0));
            assertEquals(GameMapException.INVALID_WIDTH, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> gameMap4.setHeight(0));
            assertEquals(GameMapException.INVALID_HEIGHT, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> gameMap4.setDepth(0));
            assertEquals(GameMapException.INVALID_DEPTH, exception.getMessage());

            exception = assertThrows(GameMapException.class, () -> gameMap4.setGameMapType(null));
            assertEquals(GameMapException.MAP_TYPE_NULL, exception.getMessage());
        } catch (GameMapException e) {
            fail("[ERROR] There is some problem with the definition of the setters: " + e.getMessage());
        }

    }

}
