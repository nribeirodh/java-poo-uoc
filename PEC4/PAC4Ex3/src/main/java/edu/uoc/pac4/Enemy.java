package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;

public abstract class Enemy extends Entity {

    private static final double MAX_GROUP_LEADER_DISTANCE = 50.0;
    private int id;
    private int minGold;
    private int maxGold;
    private int experience;
    private int minDamage;
    private int maxDamage;
    private Enemy groupLeader;

    protected Enemy(String name, int level, int maxHP, Position position, int id, int minGold, int maxGold, int experience, int minDamage, int maxDamage, Enemy groupLeader) throws EntityException {
        super(name, level, maxHP, position);
        this.id = id;
        this.minGold = Math.max(0, minGold);
        this.maxGold = Math.max(this.minGold, maxGold);
        this.experience = Math.max(0, experience);
        this.minDamage = Math.max(0, minDamage);
        this.maxDamage = Math.max(this.minDamage, maxDamage);
        this.groupLeader = groupLeader;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getMinGold() {
        return minGold;
    }

    public int getMaxGold() {
        return maxGold;
    }

    public void setGold(int minGold, int maxGold) {
        this.minGold = Math.max(0, minGold);
        this.maxGold = Math.max(this.minGold, maxGold);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = Math.max(0, experience);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setDamage(int minDamage, int maxDamage) {
        this.minDamage = Math.max(0, minDamage);
        this.maxDamage = Math.max(this.minDamage, maxDamage);
    }

    public Enemy getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Enemy groupLeader) {
        this.groupLeader = groupLeader;
    }

    public boolean isFarFromGroupLeader() {
        if (this.groupLeader == null) {
            return false;
        }
        return this.getPosition().euclideanDistance(this.groupLeader.getPosition()) > MAX_GROUP_LEADER_DISTANCE;
    }
}
