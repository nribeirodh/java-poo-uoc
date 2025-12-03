package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;

public abstract class Entity implements Movable {
    public static final int MAX_LEVEL = 99;
    private static Integer nextVid = 1;
    private Integer vid;
    private String name;
    private int level;
    private Position position;
    private int maxHP;
    private int currentHP;

    protected Entity(String name, int level, int maxHP, Position position) throws EntityException {
        //this.vid = nextVid++;
        setVid();
        setName(name);
        setLevel(level);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
        setPosition(position);
    }

    public static Integer getNextVid() {
        return nextVid;
    }

    public Integer getVid() {
        return vid;
    }

    private void setVid() {
        this.vid = nextVid++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EntityException {
        if (name == null || name.isEmpty()) {
            throw new EntityException(EntityException.INVALID_NAME);
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws EntityException {
        if (level < 1 || level > MAX_LEVEL) {
            throw new EntityException(EntityException.INVALID_LEVEL);
        }
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) throws EntityException {
        if (position == null) {
            throw new EntityException(EntityException.POSITION_NULL);
        }
        this.position = position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(1, maxHP);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        if (currentHP < 0) {
            this.currentHP = 0;
        } else {
            this.currentHP = Math.min(currentHP, maxHP);
        }
    }
  /*
    @Override
    public boolean move(Position position) {
        try {
            setPosition(position);
            return true;
        } catch (EntityException e) {
            return false;
        }
    }*/

}
