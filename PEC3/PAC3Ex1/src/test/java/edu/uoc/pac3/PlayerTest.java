package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest {

    @Test
    @Order(4)
    @DisplayName("Player creation - Valid parameters")
    void testCreatePlayer() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals("UOCoder", player.getName());
        assertEquals(94, player.getLevel());
        assertEquals(LocalDate.of(2010, 6, 21), player.getCreationDate());
        assertEquals(1814690, player.getExperience());
        assertEquals(51841060, player.getGold());
        assertEquals(5.9, player.getHealthRegenPerSec());
        assertEquals(10.6, player.getCriticalPct());
        assertEquals(5.4, player.getDodgePct());
        assertEquals("Chivalric", player.getHonorTitle());
        assertNull(player.getPet());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric", "BaoBao", 35, LocalDate.of(2014, 12, 21), 100, 100, false);

        assertNotNull(player);
        assertEquals("UOCoder", player.getName());
        assertEquals(94, player.getLevel());
        assertEquals(LocalDate.of(2010, 6, 21), player.getCreationDate());
        assertEquals(1814690, player.getExperience());
        assertEquals(51841060, player.getGold());
        assertEquals(5.9, player.getHealthRegenPerSec());
        assertEquals(10.6, player.getCriticalPct());
        assertEquals(5.4, player.getDodgePct());
        assertEquals("Chivalric", player.getHonorTitle());

        assertNotNull(player.getPet());
        assertEquals("BaoBao", player.getPet().getName());
        assertEquals(35, player.getPet().getLevel());
        assertEquals(LocalDate.of(2014, 12, 21), player.getPet().getBirthdate());
        assertEquals(100, player.getPet().getLoyalty());
        assertEquals(100, player.getPet().getStamina());
        assertFalse(player.getPet().isAggressive());
    }

    @Test
    @Order(5)
    @DisplayName("Player creation - Valid name")
    void testCreatePlayerValidName() {
        Player player = new Player("   ?%$&=$·?··    ", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals("?%$&=$·?··", player.getName());

        player = new Player("14545 5154  541547", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals("14545 5154  541547", player.getName());

        player = new Player("Th1$ 1$ my n4m3", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals("Th1$ 1$ my n4m3", player.getName());

        player = new Player("SimpleName", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals("SimpleName", player.getName());
    }

    @Test
    @Order(6)
    @DisplayName("Player creation - Invalid name")
    void testCreatePlayerInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(null, 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("  ", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOC", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("A".repeat(51), 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_NAME, exception.getMessage());
    }

    @Test
    @Order(7)
    @DisplayName("Player creation - valid level")
    void testCreatePlayerValidLevel() {
        Player player = new Player("UOCoder", 1, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(1, player.getLevel());

        player = new Player("UOCoder", 50, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(50, player.getLevel());

        player = new Player("UOCoder", 99, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(99, player.getLevel());
    }

    @Test
    @Order(8)
    @DisplayName("Player creation - Invalid level")
    void testCreatePlayerInvalidLevel() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 0, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_LEVEL, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 100, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_LEVEL, exception.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("Player creation - Valid creation date")
    void testCreatePlayerValidCreationDate() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(LocalDate.of(2010, 6, 21), player.getCreationDate());

        player = new Player("UOCoder", 94, LocalDate.of(2021, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(LocalDate.of(2021, 6, 21), player.getCreationDate());
    }

    @Test
    @Order(10)
    @DisplayName("Player creation - Invalid creation date")
    void testCreatePlayerInvalidCreationDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, null, 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CREATION_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.now().plusDays(1), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CREATION_DATE, exception.getMessage());
    }

    @Test
    @Order(11)
    @DisplayName("Player creation - Valid experience")
    void testCreatePlayerValidExperience() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 0, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(0, player.getExperience());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 51841060, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(51841060, player.getExperience());
    }

    @Test
    @Order(12)
    @DisplayName("Player creation - Invalid experience")
    void testCreatePlayerInvalidExperience() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), -1, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_EXPERIENCE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), -10000, 51841060, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_EXPERIENCE, exception.getMessage());
    }

    @Test
    @Order(13)
    @DisplayName("Player creation - Valid gold")
    void testCreatePlayerValidGold() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 0, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(0, player.getGold());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(51841060, player.getGold());
    }

    @Test
    @Order(14)
    @DisplayName("Player creation - Invalid gold")
    void testCreatePlayerInvalidGold() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, -1, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_GOLD, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, -10000, 5.9, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_GOLD, exception.getMessage());
    }

    @Test
    @Order(15)
    @DisplayName("Player creation - Valid health regen per sec")
    void testCreatePlayerValidHealthRegenPerSec() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 0.0, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(0.0, player.getHealthRegenPerSec());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 55.5, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(55.5, player.getHealthRegenPerSec());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 100.0, 10.6, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(100.0, player.getHealthRegenPerSec());
    }

    @Test
    @Order(16)
    @DisplayName("Player creation - Invalid health regen per sec")
    void testCreatePlayerInvalidHealthRegenPerSec() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, -0.1, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_HEALTH_REGEN_PER_SEC, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, -100.0, 10.6, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_HEALTH_REGEN_PER_SEC, exception.getMessage());
    }

    @Test
    @Order(17)
    @DisplayName("Player creation - Valid critical pct")
    void testCreatePlayerValidCriticalPct() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 0.0, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(0.0, player.getCriticalPct());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 50.5, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(50.5, player.getCriticalPct());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 100.0, 5.4, "Chivalric");

        assertNotNull(player);
        assertEquals(100.0, player.getCriticalPct());
    }

    @Test
    @Order(18)
    @DisplayName("Player creation - Invalid critical pct")
    void testCreatePlayerInvalidCriticalPct() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, -0.1, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CRITICAL_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, -1000.0, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CRITICAL_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 100.1, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CRITICAL_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 1000.0, 5.4, "Chivalric"));
        assertEquals(Player.INVALID_CRITICAL_PCT, exception.getMessage());
    }

    @Test
    @Order(19)
    @DisplayName("Player creation - Valid dodge pct")
    void testCreatePlayerValidDodgePct() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 0.0, "Chivalric");

        assertNotNull(player);
        assertEquals(0.0, player.getDodgePct());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 50.5, "Chivalric");

        assertNotNull(player);
        assertEquals(50.5, player.getDodgePct());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 100.0, "Chivalric");

        assertNotNull(player);
        assertEquals(100.0, player.getDodgePct());
    }

    @Test
    @Order(20)
    @DisplayName("Player creation - Invalid dodge pct")
    void testCreatePlayerInvalidDodgePct() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, -0.1, "Chivalric"));
        assertEquals(Player.INVALID_DODGE_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, -1000.0, "Chivalric"));
        assertEquals(Player.INVALID_DODGE_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 100.1, "Chivalric"));
        assertEquals(Player.INVALID_DODGE_PCT, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 1000.0, "Chivalric"));
        assertEquals(Player.INVALID_DODGE_PCT, exception.getMessage());
    }

    @Test
    @Order(21)
    @DisplayName("Player creation - Valid honor title")
    void testCreatePlayerValidHonorTitle() {
        Player player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "  Chivalric  ");

        assertNotNull(player);
        assertEquals("Chivalric", player.getHonorTitle());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "C h i v a l r i c");

        assertNotNull(player);
        assertEquals("C h i v a l r i c", player.getHonorTitle());

        player = new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric Knight");

        assertNotNull(player);
        assertEquals("Chivalric Knight", player.getHonorTitle());
    }

    @Test
    @Order(22)
    @DisplayName("Player creation - Invalid honor title")
    void testCreatePlayerInvalidHonorTitle() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, null));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, ""));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "  "));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric!"));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric! "));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric!"));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "Chivalric! "));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Player("UOCoder", 94, LocalDate.of(2010, 6, 21), 1814690, 51841060, 5.9, 10.6, 5.4, "A".repeat(31)));
        assertEquals(Player.INVALID_HONOR_TITLE, exception.getMessage());
    }

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        //check attribute fields
        assertEquals(23, Player.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_NAME").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_LEVEL").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_CREATION_DATE").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_EXPERIENCE").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_EXPERIENCE").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_EXPERIENCE").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_EXPERIENCE").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_GOLD").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_GOLD").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_GOLD").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_GOLD").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_HEALTH_REGEN_PER_SEC").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_HEALTH_REGEN_PER_SEC").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_HEALTH_REGEN_PER_SEC").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_HEALTH_REGEN_PER_SEC").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_CRITICAL_PCT").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_CRITICAL_PCT").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_CRITICAL_PCT").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_CRITICAL_PCT").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_DODGE_PCT").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_DODGE_PCT").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_DODGE_PCT").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_DODGE_PCT").getType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredField("INVALID_HONOR_TITLE").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("INVALID_HONOR_TITLE").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("INVALID_HONOR_TITLE").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("INVALID_HONOR_TITLE").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("MAX_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("MAX_LEVEL").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("MAX_HONOR_TITLE_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Player.class.getDeclaredField("MAX_HONOR_TITLE_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Player.class.getDeclaredField("MAX_HONOR_TITLE_LENGTH").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("MAX_HONOR_TITLE_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("level").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("level").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("creationDate").getModifiers()));
            assertEquals(LocalDate.class, Player.class.getDeclaredField("creationDate").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("experience").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("experience").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("experience").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("experience").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("gold").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("gold").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("gold").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredField("gold").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("healthRegenPerSec").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("healthRegenPerSec").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("healthRegenPerSec").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredField("healthRegenPerSec").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("criticalPct").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("criticalPct").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("criticalPct").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredField("criticalPct").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("dodgePct").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("dodgePct").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("dodgePct").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredField("dodgePct").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("honorTitle").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("honorTitle").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("honorTitle").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredField("honorTitle").getType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredField("pet").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredField("pet").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredField("pet").getModifiers()));
            assertEquals(Pet.class, Player.class.getDeclaredField("pet").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructorsSanity() {
        //check constructors
        assertEquals(2, Player.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Player.class.getDeclaredConstructor(String.class, int.class, LocalDate.class, int.class, int.class, double.class, double.class, double.class, String.class).getModifiers()));
            assertTrue(Modifier.isPublic(Player.class.getDeclaredConstructor(String.class, int.class, LocalDate.class, int.class, int.class, double.class, double.class, double.class, String.class, String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        //check methods
        assertEquals(20, Player.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getLevel").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredMethod("getLevel").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setLevel", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertEquals(LocalDate.class, Player.class.getDeclaredMethod("getCreationDate").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setCreationDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getExperience").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getExperience").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getExperience").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredMethod("getExperience").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setExperience", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setExperience", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setExperience", int.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setExperience", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getGold").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getGold").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getGold").getModifiers()));
            assertEquals(int.class, Player.class.getDeclaredMethod("getGold").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setGold", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setGold", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setGold", int.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setGold", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getHealthRegenPerSec").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getHealthRegenPerSec").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getHealthRegenPerSec").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredMethod("getHealthRegenPerSec").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setHealthRegenPerSec", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setHealthRegenPerSec", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setHealthRegenPerSec", double.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setHealthRegenPerSec", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getCriticalPct").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getCriticalPct").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getCriticalPct").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredMethod("getCriticalPct").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setCriticalPct", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setCriticalPct", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setCriticalPct", double.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setCriticalPct", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getDodgePct").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getDodgePct").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getDodgePct").getModifiers()));
            assertEquals(double.class, Player.class.getDeclaredMethod("getDodgePct").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setDodgePct", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setDodgePct", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setDodgePct", double.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setDodgePct", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getHonorTitle").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getHonorTitle").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getHonorTitle").getModifiers()));
            assertEquals(String.class, Player.class.getDeclaredMethod("getHonorTitle").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setHonorTitle", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setHonorTitle", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setHonorTitle", String.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setHonorTitle", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Player.class.getDeclaredMethod("getPet").getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("getPet").getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("getPet").getModifiers()));
            assertEquals(Pet.class, Player.class.getDeclaredMethod("getPet").getReturnType());

            assertTrue(Modifier.isPrivate(Player.class.getDeclaredMethod("setPet", String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Player.class.getDeclaredMethod("setPet", String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Player.class.getDeclaredMethod("setPet", String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getModifiers()));
            assertEquals(void.class, Player.class.getDeclaredMethod("setPet", String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }

    }

}
