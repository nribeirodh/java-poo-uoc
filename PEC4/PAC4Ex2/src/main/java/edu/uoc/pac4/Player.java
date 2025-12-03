package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public abstract class Player extends Entity implements Speakable {

    private int currentGold;
    private int currentExperience;
    private int vitality;
    private int intelligence;
    private int strength;
    private int agility;
    private Empire empire;
    private static final int MAX_STAT = 90;

    protected Player(String name, int level, int maxHP, Position position, int currentGold, int currentExperience, int vitality, int intelligence, int strength, int agility, Empire empire) throws PlayerException, EntityException {
        super(name, level, maxHP, position);
        setCurrentGold(currentGold);
        setCurrentExperience(currentExperience);
        setVitality(vitality);
        setIntelligence(intelligence);
        this.strength = strength;
        this.agility = agility;
        setEmpire(empire);
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(int currentGold) {
        this.currentGold = Math.max(0, currentGold);
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = Math.max(0, currentExperience);
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = Math.min(Math.max(0, vitality), MAX_STAT);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = Math.min(Math.max(0, intelligence), MAX_STAT);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.min(Math.max(0, strength), MAX_STAT);
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = Math.min(Math.max(0, agility), MAX_STAT);
    }

    public Empire getEmpire() {
        return empire;
    }

    public void setEmpire(Empire empire) throws PlayerException {
        if (empire == null) {
            throw new PlayerException(PlayerException.EMPIRE_NULL);
        }
        this.empire = empire;
    }

    @Override
    public String sayName() {
        return getName() + ": ";
    }

}
