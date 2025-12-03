package edu.uoc.pac3;

import java.time.LocalDate;

public class Player {
	
    public static final String INVALID_NAME = "[ERROR] The name cannot be null, empty, consist solely of spaces, and it must be within the predefined minimum and maximum character limits.";
    public static final String INVALID_LEVEL = "[ERROR] The level must be between 1 and the predefined maximum.";
    public static final String INVALID_CREATION_DATE = "[ERROR] The creation date cannot be null or in the future.";
    public static final String INVALID_EXPERIENCE = "[ERROR] The experience must be greater than or equal to 0.";
    public static final String INVALID_GOLD = "[ERROR] The gold must be greater than or equal to 0.";
    public static final String INVALID_HEALTH_REGEN_PER_SEC = "[ERROR] The health regen per second must be greater than or equal to 0.";
    public static final String INVALID_CRITICAL_PCT = "[ERROR] The critical percentage must be between 0.0 and 100.0.";
    public static final String INVALID_DODGE_PCT = "[ERROR] The dodge percentage must be between 0.0 and 100.0.";
    public static final String INVALID_HONOR_TITLE = "[ERROR] The honor title cannot be null, empty, consist solely of spaces, cannot exceed the predefined maximum character limit, and can only contain characters from the English alphabet and whitespaces.";

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_LEVEL = 99;
    private static final int MAX_HONOR_TITLE_LENGTH = 30;
    
    private String name;
    private int level;
    private LocalDate creationDate;
    private int experience;
    private int gold;
    private double healthRegenPerSec;
    private double criticalPct;
    private double dodgePct;
    private String honorTitle;
    private Pet pet;
    
    public Player(String name, int level, LocalDate creationDate, int experience, int gold, double healthRegenPerSec, double criticalPct, double dodgePct, String honorTitle) {
        setName(name);
        setLevel(level);
        setCreationDate(creationDate);
        setExperience(experience);
        setGold(gold);
        setHealthRegenPerSec(healthRegenPerSec);
        setCriticalPct(criticalPct);
        setDodgePct(dodgePct);
        setHonorTitle(honorTitle);
        this.pet = null;
    }
    
    public Player(String name, int level, LocalDate creationDate, int experience, int gold, double healthRegenPerSec, double criticalPct, double dodgePct, String honorTitle, String petName, int petLevel, LocalDate petBirthday, int petLoyalty, int petStamina, boolean petlsAggressive) {
        setName(name);
        setLevel(level);
        setCreationDate(creationDate);
        setExperience(experience);
        setGold(gold);
        setHealthRegenPerSec(healthRegenPerSec);
        setCriticalPct(criticalPct);
        setDodgePct(dodgePct);
        setHonorTitle(honorTitle);
        setPet(petName, petLevel, petBirthday, petLoyalty, petStamina, petlsAggressive);
    }
    

    
    public String getName() {
        return name;
    }

    private void setName(String name) {
    	if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        String trimmedName = name.trim(); //Eliminamos los caracteres en blanco al inicio y al final
        if (trimmedName.length() < MIN_NAME_LENGTH || trimmedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = trimmedName;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        if (level < 1 || level > MAX_LEVEL) {
            throw new IllegalArgumentException(INVALID_LEVEL);
        }
        this.level = level;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(LocalDate creationDate) {
        if (creationDate == null || creationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_CREATION_DATE);
        }
        this.creationDate = creationDate;
    }

    public int getExperience() {
        return experience;
    }

    private void setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException(INVALID_EXPERIENCE);
        }
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    private void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException(INVALID_GOLD);
        }
        this.gold = gold;
    }

    public double getHealthRegenPerSec() {
        return healthRegenPerSec;
    }

    private void setHealthRegenPerSec(double healthRegenPerSec) {
        if (healthRegenPerSec < 0) {
            throw new IllegalArgumentException(INVALID_HEALTH_REGEN_PER_SEC);
        }
        this.healthRegenPerSec = healthRegenPerSec;
    }

    public double getCriticalPct() {
        return criticalPct;
    }

    private void setCriticalPct(double criticalPct) {
        if (criticalPct < 0.0 || criticalPct > 100.0) {
            throw new IllegalArgumentException(INVALID_CRITICAL_PCT);
        }
        this.criticalPct = criticalPct;
    }

    public double getDodgePct() {
        return dodgePct;
    }

    private void setDodgePct(double dodgePct) {
        if (dodgePct < 0.0 || dodgePct > 100.0) {
            throw new IllegalArgumentException(INVALID_DODGE_PCT);
        }
        this.dodgePct = dodgePct;
    }

    public String getHonorTitle() {
        return honorTitle;
    }

    private void setHonorTitle(String honorTitle) {
        if (honorTitle == null) {
            throw new IllegalArgumentException(INVALID_HONOR_TITLE);
        }

        honorTitle = honorTitle.trim();

        if (honorTitle.isEmpty() || honorTitle.length() > MAX_HONOR_TITLE_LENGTH) {
            throw new IllegalArgumentException(INVALID_HONOR_TITLE);
        }

        if (!honorTitle.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException(INVALID_HONOR_TITLE);
        }

        this.honorTitle = honorTitle;
    }

    public Pet getPet() {
        return pet;
    }

    private void setPet(String petName, int petLevel, LocalDate petBirthday, int petLoyalty, int petStamina, boolean petlsAggressive) {
        this.pet = new Pet(petName, petLevel, petBirthday, petLoyalty, petStamina, petlsAggressive);
    }
}
