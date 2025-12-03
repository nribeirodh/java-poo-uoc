package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Ninja extends Player {

    public static final int VITALITY = 4;
    public static final int INTELLIGENCE = 6;
    public static final int STRENGTH = 3;
    public static final int AGILITY = 3;
    public static final int MAX_HP = 180;
    private static final double MAX_STEP = 10.0;

    public Ninja(String name, Position position, Empire empire) throws PlayerException, EntityException {
        super(name, 1, MAX_HP, position, 0, 0, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    public Ninja(String name, int level, int maxHP, Position position, int currentGold, int currentExperience, int vitality, int intelligence, int strength, int agility, Empire empire) throws PlayerException, EntityException {
        super(name, level, maxHP, position, currentGold, currentExperience, vitality, intelligence, strength, agility, empire);
    }

    @Override
    public boolean move(Position position) {
        if (getPosition().euclideanDistance(position) <= MAX_STEP) {
            try {
                setPosition(position);
                return true;
            } catch (EntityException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public String battleCry() {
        return sayName() + "Strike swift, strike silent!";
    }

    @Override
    public String deathCry() {
        return sayName() + "Silence, at last...";
    }
}
