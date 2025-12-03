package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerRaceTest {

    @Test
    @Order(3)
    @DisplayName("Player race - Name")
    void testPlayerRaceName() {
        assertEquals("Warrior", PlayerRace.WARRIOR.getName());
        assertEquals("Ninja", PlayerRace.NINJA.getName());
        assertEquals("Shaman", PlayerRace.SHAMAN.getName());
        assertEquals("Dark Mage", PlayerRace.DARK_MAGE.getName());
    }

    @Test
    @Order(4)
    @DisplayName("Player race - Max. HP")
    void testPlayerRaceMaxHP() {
        assertEquals(150, PlayerRace.WARRIOR.getMaxHP());
        assertEquals(120, PlayerRace.NINJA.getMaxHP());
        assertEquals(110, PlayerRace.SHAMAN.getMaxHP());
        assertEquals(130, PlayerRace.DARK_MAGE.getMaxHP());
    }

    @Test
    @Order(5)
    @DisplayName("Player race - Vitality")
    void testPlayerRaceVitality() {
        assertEquals(18, PlayerRace.WARRIOR.getVitality());
        assertEquals(12, PlayerRace.NINJA.getVitality());
        assertEquals(10, PlayerRace.SHAMAN.getVitality());
        assertEquals(15, PlayerRace.DARK_MAGE.getVitality());
    }

    @Test
    @Order(6)
    @DisplayName("Player race - Intelligence")
    void testPlayerRaceIntelligence() {
        assertEquals(6, PlayerRace.WARRIOR.getIntelligence());
        assertEquals(14, PlayerRace.NINJA.getIntelligence());
        assertEquals(20, PlayerRace.SHAMAN.getIntelligence());
        assertEquals(15, PlayerRace.DARK_MAGE.getIntelligence());
    }

    @Test
    @Order(7)
    @DisplayName("Player race - Strength")
    void testPlayerRaceStrength() {
        assertEquals(20, PlayerRace.WARRIOR.getStrength());
        assertEquals(15, PlayerRace.NINJA.getStrength());
        assertEquals(10, PlayerRace.SHAMAN.getStrength());
        assertEquals(18, PlayerRace.DARK_MAGE.getStrength());
    }

    @Test
    @Order(8)
    @DisplayName("Player race - Agility")
    void testPlayerRaceAgility() {
        assertEquals(10, PlayerRace.WARRIOR.getAgility());
        assertEquals(18, PlayerRace.NINJA.getAgility());
        assertEquals(12, PlayerRace.SHAMAN.getAgility());
        assertEquals(10, PlayerRace.DARK_MAGE.getAgility());
    }

    @Test
    @Order(9)
    @DisplayName("Player race - getRace")
    void testPlayerRaceGetRace() {
        assertEquals(PlayerRace.WARRIOR, PlayerRace.getRace("Warrior"));
        assertEquals(PlayerRace.NINJA, PlayerRace.getRace("Ninja"));
        assertEquals(PlayerRace.SHAMAN, PlayerRace.getRace("Shaman"));
        assertEquals(PlayerRace.DARK_MAGE, PlayerRace.getRace("Dark Mage"));

        assertNull(PlayerRace.getRace(null));
        assertNull(PlayerRace.getRace("Invalid"));
    }

    @Test
    @Order(10)
    @DisplayName("Player race - getBestPartner")
    void testPlayerRaceGetBestPartner() {
        assertEquals(PlayerRace.SHAMAN, PlayerRace.WARRIOR.getBestPartner());
        assertEquals(PlayerRace.DARK_MAGE, PlayerRace.NINJA.getBestPartner());
        assertEquals(PlayerRace.WARRIOR, PlayerRace.SHAMAN.getBestPartner());
        assertEquals(PlayerRace.NINJA, PlayerRace.DARK_MAGE.getBestPartner());
    }

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        //check attribute fields: 6 fields + 4 values + 1 hidden
        assertEquals(11, PlayerRace.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("name").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, PlayerRace.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("maxHP").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("maxHP").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("maxHP").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredField("maxHP").getType());

            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("vitality").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("vitality").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("vitality").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredField("vitality").getType());

            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("intelligence").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("intelligence").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("intelligence").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredField("intelligence").getType());

            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("strength").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("strength").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("strength").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredField("strength").getType());

            assertTrue(Modifier.isPrivate(PlayerRace.class.getDeclaredField("agility").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredField("agility").getModifiers()));
            assertTrue(Modifier.isFinal(PlayerRace.class.getDeclaredField("agility").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredField("agility").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        //check constructor
        assertEquals(1, PlayerRace.class.getDeclaredConstructors().length);

        //check methods: 8 methods + 2 hidden
        assertEquals(10, Arrays.stream(PlayerRace.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, PlayerRace.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getMaxHP").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getMaxHP").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getMaxHP").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredMethod("getMaxHP").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getVitality").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getVitality").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getVitality").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredMethod("getVitality").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getIntelligence").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getIntelligence").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getIntelligence").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredMethod("getIntelligence").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getStrength").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getStrength").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getStrength").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredMethod("getStrength").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getAgility").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getAgility").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getAgility").getModifiers()));
            assertEquals(int.class, PlayerRace.class.getDeclaredMethod("getAgility").getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getRace", String.class).getModifiers()));
            assertTrue(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getRace", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getRace", String.class).getModifiers()));
            assertEquals(PlayerRace.class, PlayerRace.class.getDeclaredMethod("getRace", String.class).getReturnType());

            assertTrue(Modifier.isPublic(PlayerRace.class.getDeclaredMethod("getBestPartner").getModifiers()));
            assertFalse(Modifier.isStatic(PlayerRace.class.getDeclaredMethod("getBestPartner").getModifiers()));
            assertFalse(Modifier.isFinal(PlayerRace.class.getDeclaredMethod("getBestPartner").getModifiers()));
            assertEquals(PlayerRace.class, PlayerRace.class.getDeclaredMethod("getBestPartner").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

}
