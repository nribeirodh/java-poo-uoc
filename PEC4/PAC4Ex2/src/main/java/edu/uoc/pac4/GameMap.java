package edu.uoc.pac4;

import edu.uoc.pac4.exception.GameMapException;

import java.util.Hashtable;
import java.util.Map;

public class GameMap {
    public static final int MAX_ENTITIES = 1000;
    private int gameMapId;
    private String name;
    private int width;
    private int height;
    private int depth;
    private GameMapType gameMapType;
    private Map<Integer, Entity> entities;

    public GameMap(int gameMapId, String name, int width, int height, int depth, GameMapType gameMapType) throws GameMapException {
        setGameMapId(gameMapId);
        setName(name);
        setWidth(width);
        setHeight(height);
        setDepth(depth);
        setGameMapType(gameMapType);
        this.entities = new Hashtable<>();
    }

    public int getGameMapId() {
        return gameMapId;
    }

    private void setGameMapId(int gameMapId) throws GameMapException {
        if (gameMapId <= 0) {
            throw new GameMapException(GameMapException.INVALID_GAME_MAP_ID);
        }
        this.gameMapId = gameMapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws GameMapException {
        if (name == null || name.isEmpty()) {
            throw new GameMapException(GameMapException.INVALID_NAME);
        }
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws GameMapException {
        if (width <= 0) {
            throw new GameMapException(GameMapException.INVALID_WIDTH);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws GameMapException {
        if (height <= 0) {
            throw new GameMapException(GameMapException.INVALID_HEIGHT);
        }
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) throws GameMapException {
        if (depth <= 0) {
            throw new GameMapException(GameMapException.INVALID_DEPTH);
        }
        this.depth = depth;
    }

    public GameMapType getGameMapType() {
        return gameMapType;
    }

    public void setGameMapType(GameMapType gameMapType) throws GameMapException {
        if (gameMapType == null) {
            throw new GameMapException(GameMapException.MAP_TYPE_NULL);
        }
        this.gameMapType = gameMapType;
    }

    public void addEntity(Entity entity) {
        entities.put(entity.getVid(), entity);
    }

    public void removeEntity(Integer vid) {
        entities.remove(vid);
    }

    public Entity getEntity(Integer vid) {
        return entities.get(vid);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GameMap gameMap = (GameMap) obj;
        return gameMapId == gameMap.gameMapId;
    }

    @Override
    public String toString() {
        return gameMapId + " | " + name + " (" + width + "x" + height + "x" + depth + ") | " + gameMapType;
    }
}
