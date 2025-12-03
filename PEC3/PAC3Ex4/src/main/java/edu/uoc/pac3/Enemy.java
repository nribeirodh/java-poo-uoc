package edu.uoc.pac3;

public class Enemy {
    public static final String INVALID_NAME = "Name cannot be null and must be between 1 and 50 characters.";
    public static final String INVALID_MIN_DAMAGE = "Min damage must be greater than 0.";
    public static final String INVALID_MAX_DAMAGE = "Max damage must be greater than or equal to min damage.";

    private static final int MAX_NAME_LENGTH = 50;
    private static final double MAX_STEP = 10.0;

    private String name;
    private int health;
    private int minDamage;
    private int maxDamage;
    private Position position;
    private boolean isDead;

    public Enemy(String name, int health, int minDamage, int maxDamage, int x, int y) {
        isDead = false;

        setName(name);
        setHealth(health);
        setDamage(minDamage, maxDamage);
        setPosition(x, y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            isDead = true;
        }

        this.health = Math.max(health, 0);
    }

    public int getMinDamage() {
        return minDamage;
    }

    private void setMinDamage(int minDamage) {
        if (minDamage <= 0) {
            throw new IllegalArgumentException(INVALID_MIN_DAMAGE);
        }

        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    private void setMaxDamage(int maxDamage) {
        if (maxDamage < minDamage) {
            throw new IllegalArgumentException(INVALID_MAX_DAMAGE);
        }

        this.maxDamage = maxDamage;
    }

    public void setDamage(int minDamage, int maxDamage) {
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean move(int x, int y) {
        if (Position.distance(getPosition(), new Position(x, y)) > MAX_STEP) {
            return false;
        }

        position.setX(x);
        position.setY(y);

        return true;
    }

    public int attack() {
        return (int) (Math.random() * (maxDamage - minDamage + 1) + minDamage);
    }

    public void receiveDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
