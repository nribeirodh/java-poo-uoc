package edu.uoc.pac3;

import java.time.LocalDate;

public class Pet {
	
	public static final String INVALID_NAME = "[ERROR] The name cannot be null or empty, and it must be within the predefined minimum and maximum character limits.";
    public static final String INVALID_LEVEL = "[ERROR] The level must be between 1 and the predefined maximum.";
    public static final String INVALID_BIRTHDATE = "[ERROR] The birthdate cannot be null or in the future.";
    public static final String INVALID_LOYALTY = "[ERROR] Loyalty must be within 0 and 100.";
    public static final String INVALID_STAMINA = "[ERROR] Stamina must be within 0 and 100.";
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_LEVEL = 60;
    
    private String name;
    private int level;
    private LocalDate birthdate;
    private int loyalty;
    private int stamina;
    private boolean aggressive;
    
    public Pet(String name, int level, LocalDate birthdate, int loyalty, int stamina, boolean aggressive) {
        setName(name);
        setLevel(level);
        setBirthdate(birthdate);
        setLoyalty(loyalty);
        setStamina(stamina);
        setAggressive(aggressive);
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
    
    public LocalDate getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(LocalDate birthdate) {
        if (birthdate == null || birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_BIRTHDATE);
        }
        this.birthdate = birthdate;
    }

    public int getLoyalty() {
        return loyalty;
    }

    private void setLoyalty(int loyalty) {
        if (loyalty < 0 || loyalty > 100) {
            throw new IllegalArgumentException(INVALID_LOYALTY);
        }
        this.loyalty = loyalty;
    }

    public int getStamina() {
        return stamina;
    }

    private void setStamina(int stamina) {
        if (stamina < 0 || stamina > 100) {
            throw new IllegalArgumentException(INVALID_STAMINA);
        }
        this.stamina = stamina;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    private void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }


}
