package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Warrior extends Player {

    public static final int VITALITY = 4;
    public static final int INTELLIGENCE = 3;
    public static final int STRENGTH = 6;
    public static final int AGILITY = 3;
    public static final int MAX_HP = 250;
    private static final double MAX_STEP = 20.0;

    public Warrior(String name, Position position, Empire empire) throws PlayerException, EntityException {
        super(name, 1, MAX_HP, position, 0, 0, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    public Warrior(String name, int level, int maxHP, Position position, int currentGold, int currentExperience, int vitality, int intelligence, int strength, int agility, Empire empire) throws PlayerException, EntityException {
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
        return sayName() + "To victory or death!";
    }

    @Override
    public String deathCry() {
        return sayName() + "I shall return, stronger than ever...";
    }
}
