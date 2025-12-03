package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class DarkMage extends Player {

    public static final int VITALITY = 3;
    public static final int INTELLIGENCE = 5;
    public static final int STRENGTH = 5;
    public static final int AGILITY = 3;
    public static final int MAX_HP = 200;
    private static final double MAX_STEP = 12.0;


    public DarkMage(String name, Position position, Empire empire) throws PlayerException, EntityException {
        super(name, 1, MAX_HP, position, 0, 0, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    public DarkMage(String name, int level, int maxHP, Position position, int currentGold, int currentExperience, int vitality, int intelligence, int strength, int agility, Empire empire) throws PlayerException, EntityException {
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
        return sayName() + "Let the darkness reign!";
    }

    @Override
    public String deathCry() {
        return sayName() + "The dark arts will live on...";
    }
}
