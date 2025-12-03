package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameMapStreamTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        try {
            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getNumPlayers").getModifiers()), "The method getTotalPlayersCount must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getNumPlayers").getModifiers()), "The method getTotalPlayersCount cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getNumPlayers").getModifiers()), "The method getTotalPlayersCount cannot be final");
            assertEquals(long.class, GameMap.class.getDeclaredMethod("getNumPlayers").getReturnType(), "The method getTotalPlayersCount must return a long");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("getNumEnemiesById", int.class).getModifiers()), "The method getTotalEnemiesByIdCount must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("getNumEnemiesById", int.class).getModifiers()), "The method getTotalEnemiesByIdCount cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("getNumEnemiesById", int.class).getModifiers()), "The method getTotalEnemiesByIdCount cannot be final");
            assertEquals(long.class, GameMap.class.getDeclaredMethod("getNumEnemiesById", int.class).getReturnType(), "The method getTotalEnemiesByIdCount must return a long");

            assertTrue(Modifier.isPublic(GameMap.class.getDeclaredMethod("findNearestEnemy", Position.class).getModifiers()), "The method getTotalEnemiesByTypeCount must be public");
            assertFalse(Modifier.isStatic(GameMap.class.getDeclaredMethod("findNearestEnemy", Position.class).getModifiers()), "The method getTotalEnemiesByTypeCount cannot be static");
            assertFalse(Modifier.isFinal(GameMap.class.getDeclaredMethod("findNearestEnemy", Position.class).getModifiers()), "The method getTotalEnemiesByTypeCount cannot be final");
            assertEquals(Entity.class, GameMap.class.getDeclaredMethod("findNearestEnemy", Position.class).getReturnType(), "The method getTotalEnemiesByTypeCount must return a Entity");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test - getNumPlayers")
    void testGetNumPlayers() {
        try {
            GameMap gameMap = new GameMap(1, "Test", 10, 10, 10, GameMapType.CITY);
            assertEquals(0, gameMap.getNumPlayers(), "The total players count must be 0");

            gameMap.addEntity(new Warrior("Warrior", new Position(gameMap, 1, 1, 1), Empire.CHUNJO));
            assertEquals(1, gameMap.getNumPlayers(), "The total players count must be 1");

            gameMap.addEntity(new Warrior("Warrior", new Position(gameMap, 1, 1, 1), Empire.CHUNJO));
            gameMap.addEntity(new DarkMage("DarkMage", new Position(gameMap, 1, 1, 1), Empire.SHINSOO));
            assertEquals(3, gameMap.getNumPlayers(), "The total players count must be 3");

            gameMap.addEntity(new Orc(new Position(gameMap, 1, 1, 1), null));
            assertEquals(3, gameMap.getNumPlayers(), "The total players count must be 3");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Test - getNumEnemiesById")
    void testGetNumEnemiesById() {
        try {
            GameMap gameMap = new GameMap(1, "Test", 10, 10, 10, GameMapType.CITY);
            assertEquals(0, gameMap.getNumEnemiesById(Orc.ID), "The total enemies count must be 0");

            gameMap.addEntity(new Orc(new Position(gameMap, 1, 1, 1), null));
            assertEquals(1, gameMap.getNumEnemiesById(Orc.ID), "The total enemies count must be 1");

            gameMap.addEntity(new Orc(new Position(gameMap, 1, 1, 1), null));
            gameMap.addEntity(new Orc(new Position(gameMap, 1, 1, 1), null));
            assertEquals(3, gameMap.getNumEnemiesById(Orc.ID), "The total enemies count must be 3");

            gameMap.addEntity(new Warrior("Warrior", new Position(gameMap, 1, 1, 1), Empire.CHUNJO));
            assertEquals(3, gameMap.getNumEnemiesById(Orc.ID), "The total enemies count must be 3");

            gameMap.addEntity(new OrcReborn(new Position(gameMap, 1, 1, 1), null));
            assertEquals(3, gameMap.getNumEnemiesById(Orc.ID), "The total enemies count must be 3");
            assertEquals(1, gameMap.getNumEnemiesById(OrcReborn.ID), "The total enemies count must be 1");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test - findNearestEnemy")
    void testFindNearestEnemy() {
        try {
            GameMap gameMap = new GameMap(1, "Test", 1024, 1024, 512, GameMapType.CITY);

            Entity entityVID10, entityVID11, entityVID12, entityMap;

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 1, 1, 1));
            assertNull(entityMap, "The nearest entity must be null");

            Entity orcVID10 = new Orc(new Position(gameMap, 1, 1, 1), null);
            gameMap.addEntity(orcVID10);

            entityVID10 = gameMap.getEntity(orcVID10.getVid());

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 1, 1, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID10.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 1");

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 10, 10, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID10.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 10");

            Entity orcVID11 = new Orc(new Position(gameMap, 8, 8, 1), null);
            gameMap.addEntity(orcVID11);

            entityVID11 = gameMap.getEntity(orcVID11.getVid());

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 2, 2, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID10.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 10");

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 7, 7, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID11.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 11");

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 10, 10, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID11.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 11");

            Entity orcVID12 = new Orc(new Position(gameMap, 150, 150, 1), null);
            gameMap.addEntity(orcVID12);

            entityVID12 = gameMap.getEntity(orcVID12.getVid());

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 10, 10, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID11.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 11");

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 100, 100, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID12.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 12");

            Entity warrior = new Warrior("Warrior", new Position(gameMap, 200, 200, 1), Empire.CHUNJO);
            gameMap.addEntity(warrior);

            entityMap = gameMap.findNearestEnemy(new Position(gameMap, 190, 190, 1));
            assertNotNull(entityMap, "The nearest entity must be not null");
            assertEquals(entityVID12.getVid(), entityMap.getVid(), "The nearest entity must be an Orc with VID = 12");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
