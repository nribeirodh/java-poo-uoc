package edu.uoc.pac3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guild {

    public static final String INVALID_NAME = "[ERROR] The name cannot be null, has less than the minimum number of characters, exceeds the maximum number of characters, or contains only whitespaces.";
    public static final String INVALID_LEVEL = "[ERROR] The level must be between 1 and 20.";
    public static final String INVALID_DESCRIPTION = "[ERROR] The description cannot be null and cannot exceed 100 characters.";
    public static final String INVALID_CREATION_DATE = "[ERROR] The creation date is invalid or null.";
    public static final String INVALID_MAX_MEMBERS = "[ERROR] The number of members cannot exceed the predefined maximum.";
    public static final String MEMBER_NULL = "[ERROR] The member cannot be null.";
    public static final String MEMBER_ALREADY_EXISTS = "[ERROR] The member already exists in the guild.";
    public static final String MEMBER_NOT_FOUND = "[ERROR] The member does not exist in the guild.";
    public static final String MEMBER_NO_PET = "[ERROR] The member does not have a pet.";

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGTH = 25;
    private static final int MAX_LEVEL = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 100;

    private static int nextId = 1;

    private int id;
    private final int NUM_MAX_MEMBERS;
    private String name;
    private int level;
    private String description;
    private LocalDate creationDate;
    private boolean recruiting;
    private int numMembers;
    private int sumLevels;
    private final Player[] members;


    public Guild(String name, int level, String description, LocalDate creationDate, boolean recruiting, int numMaxMembers) {
        setId();
        setName(name);
        setLevel(level);
        setDescription(description);
        setCreationDate(creationDate);
        this.recruiting = recruiting;
        this.NUM_MAX_MEMBERS = numMaxMembers;
        this.members = new Player[numMaxMembers];
        this.numMembers = 0;
        this.sumLevels = 0;
    }


    public int getId() {
        return id;
    }

    private void setId() {
        this.id = nextId;
        incNextId();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isRecruiting() {
        return recruiting;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public int getMaxMembers() {
        return NUM_MAX_MEMBERS;
    }

    public Player[] getMembers() {
        return members.clone();
    }

    public int getDaysOfLife() {
        return (int) ChronoUnit.DAYS.between(creationDate, LocalDate.now());
    }

    public double getAverageLevel() {
        if (numMembers == 0) return 0.0;
        return sumLevels / (double) numMembers;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setLevel(int level) {
        if (level < 1 || level > MAX_LEVEL) {
            throw new IllegalArgumentException(INVALID_LEVEL);
        }
        this.level = level;
    }

    private void setDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description;
    }

    private void setCreationDate(LocalDate creationDate) {
        if (creationDate == null || creationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_CREATION_DATE);
        }
        this.creationDate = creationDate;
    }

    private void setRecruiting(boolean recruiting) {
        this.recruiting = recruiting;
    }

    private static void incNextId() {
        nextId++;
    }

    private int findMember(Player member) {
        if (member == null) {
            throw new NullPointerException(MEMBER_NULL);
        }
        if (member.getPet() == null) {
            throw new NullPointerException(MEMBER_NO_PET);
        }

        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].equals(member)) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstEmptySlot() {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addMember(Player member) {
        if (member == null) {
            throw new NullPointerException(MEMBER_NULL);
        }
        if (member.getPet() == null) {
            throw new NullPointerException(MEMBER_NO_PET);
        }
        if (numMembers == members.length) {
            throw new IllegalStateException(INVALID_MAX_MEMBERS);
        }
        if (containsMember(member)) {
            throw new IllegalArgumentException(MEMBER_ALREADY_EXISTS);
        }

        int index = findFirstEmptySlot();
        if (index != -1) {
            members[index] = member;
            numMembers++;
            sumLevels += member.getLevel();
        }
    }

    public void removeMember(Player member) {
        int index = findMember(member);
        if (index == -1) {
            throw new IllegalArgumentException(MEMBER_NOT_FOUND);
        }

        members[index] = null;
        numMembers--;
        sumLevels -= member.getLevel();
    }

    public boolean containsMember(Player member) {
        return findMember(member) != -1;
    }

	public static int getNextId() {
		return nextId;
	}
    
    
}
