package edu.uoc.pac4;

import edu.uoc.pac4.exception.PositionException;

public class Position {
    private int x;
    private int y;
    private int z;
    private GameMap gameMap;

    public Position(GameMap gameMap, int x, int y, int z) throws PositionException {
        setGameMap(gameMap);
        setX(x);
        setY(y);
        setZ(z);
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) throws PositionException {
        if (gameMap == null) {
            throw new PositionException(PositionException.MAP_NULL);
        }
        this.gameMap = gameMap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws PositionException {
        if (x < 0) {
            throw new PositionException(PositionException.INVALID_X);
        }
        if (x >= gameMap.getWidth()) {
            throw new PositionException(PositionException.OUT_OF_BOUNDS_X);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws PositionException {
        if (y < 0) {
            throw new PositionException(PositionException.INVALID_Y);
        }
        if (y >= gameMap.getHeight()) {
            throw new PositionException(PositionException.OUT_OF_BOUNDS_Y);
        }
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) throws PositionException {
        if (z < 0) {
            throw new PositionException(PositionException.INVALID_Z);
        }
        if (z >= gameMap.getDepth()) {
            throw new PositionException(PositionException.OUT_OF_BOUNDS_Z);
        }
        this.z = z;
    }

    public double euclideanDistance(Position position) {
        int dx = this.x - position.x;
        int dy = this.y - position.y;
        int dz = this.z - position.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return x == position.x && y == position.y && z == position.z && gameMap.equals(position.gameMap);
    }

    @Override
    public String toString() {
        return gameMap.toString() + " | Position: (" + x + ", " + y + ", " + z + ")";
    }

}
