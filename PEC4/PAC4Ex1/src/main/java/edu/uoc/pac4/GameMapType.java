package edu.uoc.pac4;

public enum GameMapType {
    CITY, VALLEY, DESERT, FOREST, MOUNTAIN, OCEAN, PLAINS, ICE, VOLCANO, TEMPLE;

    @Override
    public String toString() {
        String name = this.name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}

