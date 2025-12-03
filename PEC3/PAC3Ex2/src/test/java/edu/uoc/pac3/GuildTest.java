package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GuildTest {

    @Test
    @Order(4)
    @DisplayName("Guild creation - Valid parameters")
    void testGuildCreationValidParameters() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertEquals(1, guild.getId());
        assertEquals("TheDragonS", guild.getName());
        assertEquals(20, guild.getLevel());
        assertEquals("The best of the Kingdom", guild.getDescription());
        assertEquals(LocalDate.of(2010, 6, 22), guild.getCreationDate());
        assertTrue(guild.isRecruiting());
        assertEquals(0, guild.getNumMembers());

        guild = new Guild("A".repeat(5), 10, "", LocalDate.now(), false, 20);

        assertEquals(2, guild.getId());
        assertEquals("A".repeat(5), guild.getName());
        assertEquals(10, guild.getLevel());
        assertEquals("", guild.getDescription());
        assertEquals(LocalDate.now(), guild.getCreationDate());
        assertFalse(guild.isRecruiting());
        assertEquals(0, guild.getNumMembers());
    }

    @Test
    @Order(5)
    @DisplayName("Guild creation - Valid name")
    void testGuildCreationValidName() {
        Guild guild = new Guild("This is my custom name", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals("This is my custom name", guild.getName());

        guild = new Guild("  .  ", 20, "", LocalDate.now(), true, 20);

        assertNotNull(guild);
        assertEquals("  .  ", guild.getName());

        guild = new Guild("123456789", 20, "", LocalDate.now(), true, 20);

        assertNotNull(guild);
        assertEquals("123456789", guild.getName());

        guild = new Guild("?/()&%-.,_$&/(", 20, "", LocalDate.now(), true, 20);

        assertNotNull(guild);
        assertEquals("?/()&%-.,_$&/(", guild.getName());

        guild = new Guild("A".repeat(25), 20, "", LocalDate.now(), true, 20);

        assertNotNull(guild);
        assertEquals("A".repeat(25), guild.getName());
    }

    @Test
    @Order(6)
    @DisplayName("Guild creation - Invalid name")
    void testGuildCreationInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Guild(null, 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("      ", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("A".repeat(2), 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("A".repeat(26), 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_NAME, exception.getMessage());
    }

    @Test
    @Order(7)
    @DisplayName("Guild creation - Valid level")
    void testGuildCreationValidLevel() {
        Guild guild = new Guild("TheDragonS", 1, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals(1, guild.getLevel());

        guild = new Guild("TheDragonS", 12, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals(12, guild.getLevel());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals(20, guild.getLevel());
    }

    @Test
    @Order(8)
    @DisplayName("Guild creation - Invalid level")
    void testGuildCreationInvalidLevel() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 0, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 02));
        assertEquals(Guild.INVALID_LEVEL, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 21, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_LEVEL, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", -1, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_LEVEL, exception.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("Guild creation - Valid description")
    void testGuildCreationValidDescription() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals("The best of the Kingdom", guild.getDescription());

        guild = new Guild("TheDragonS", 20, "", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals("", guild.getDescription());

        guild = new Guild("TheDragonS", 20, "  ", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals("  ", guild.getDescription());

        guild = new Guild("TheDragonS", 20, "A".repeat(100), LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals("A".repeat(100), guild.getDescription());
    }

    @Test
    @Order(10)
    @DisplayName("Guild creation - Invalid description")
    void testGuildCreationInvalidDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 20, null, LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_DESCRIPTION, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 20, "A".repeat(101), LocalDate.of(2010, 6, 22), true, 20));
        assertEquals(Guild.INVALID_DESCRIPTION, exception.getMessage());
    }

    @Test
    @Order(11)
    @DisplayName("Guild creation - Valid creation date")
    void testGuildCreationValidCreationDate() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertEquals(LocalDate.of(2010, 6, 22), guild.getCreationDate());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now().minusDays(1), true, 20);

        assertNotNull(guild);
        assertEquals(LocalDate.now().minusDays(1), guild.getCreationDate());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now(), true, 20);

        assertNotNull(guild);
        assertEquals(LocalDate.now(), guild.getCreationDate());
    }

    @Test
    @Order(12)
    @DisplayName("Guild creation - Invalid creation date")
    void testGuildCreationInvalidCreationDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 20, "The best of the Kingdom", null, true, 20));
        assertEquals(Guild.INVALID_CREATION_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now().plusDays(1), true, 20));
        assertEquals(Guild.INVALID_CREATION_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(3024, 12, 31), true, 20));
        assertEquals(Guild.INVALID_CREATION_DATE, exception.getMessage());
    }

    @Test
    @Order(13)
    @DisplayName("Guild creation - Recruiting")
    void testGuildCreationValidRecruiting() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        assertNotNull(guild);
        assertTrue(guild.isRecruiting());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), false, 20);

        assertNotNull(guild);
        assertFalse(guild.isRecruiting());
    }

    @Test
    @Order(14)
    @DisplayName("Guild creation - Get days of life")
    void testGuildGetDaysOfLife() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now(), true, 20);

        assertEquals(0, guild.getDaysOfLife());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now().minusDays(1), true, 20);

        assertEquals(1, guild.getDaysOfLife());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now().minusDays(10), true, 20);

        assertEquals(10, guild.getDaysOfLife());
    }

    @Test
    @Order(15)
    @DisplayName("Guild creation - Get max members")
    void testGuildGetMaxMembers() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now(), true, 20);
        assertEquals(20, guild.getMaxMembers());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now(), true, 10);
        assertEquals(10, guild.getMaxMembers());

        guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.now(), true, 5);
        assertEquals(5, guild.getMaxMembers());
    }

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        //check attribute fields
        assertEquals(24, Guild.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("INVALID_NAME").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("INVALID_LEVEL").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("INVALID_DESCRIPTION").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("INVALID_CREATION_DATE").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("INVALID_CREATION_DATE").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("INVALID_MAX_MEMBERS").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("INVALID_MAX_MEMBERS").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("INVALID_MAX_MEMBERS").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("INVALID_MAX_MEMBERS").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("MEMBER_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MEMBER_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MEMBER_NULL").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("MEMBER_NULL").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("MEMBER_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MEMBER_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MEMBER_ALREADY_EXISTS").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("MEMBER_ALREADY_EXISTS").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("MEMBER_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MEMBER_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MEMBER_NOT_FOUND").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("MEMBER_NOT_FOUND").getType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredField("MEMBER_NO_PET").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MEMBER_NO_PET").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MEMBER_NO_PET").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("MEMBER_NO_PET").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("MAX_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("MAX_LEVEL").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("MAX_DESCRIPTION_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("MAX_DESCRIPTION_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("MAX_DESCRIPTION_LENGTH").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("MAX_DESCRIPTION_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("NUM_MAX_MEMBERS").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("NUM_MAX_MEMBERS").getModifiers()));
            assertTrue(Modifier.isFinal(Guild.class.getDeclaredField("NUM_MAX_MEMBERS").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("NUM_MAX_MEMBERS").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("nextId").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredField("nextId").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("nextId").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("nextId").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("level").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("level").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("creationDate").getModifiers()));
            assertEquals(LocalDate.class, Guild.class.getDeclaredField("creationDate").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("recruiting").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("recruiting").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("recruiting").getModifiers()));
            assertEquals(boolean.class, Guild.class.getDeclaredField("recruiting").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("members").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("members").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("members").getModifiers()));
            assertEquals(Player[].class, Guild.class.getDeclaredField("members").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("numMembers").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("numMembers").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("numMembers").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("numMembers").getType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredField("sumLevels").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredField("sumLevels").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredField("sumLevels").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredField("sumLevels").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructorsSanity() {
        //check constructors
        assertEquals(1, Guild.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Guild.class.getDeclaredConstructor(String.class, int.class, String.class, LocalDate.class, boolean.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        //check methods, parameters and return types
        assertEquals(15, Arrays.stream(Guild.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setId").getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setId").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredMethod("getNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getNextId").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getNextId").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("incNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Guild.class.getDeclaredMethod("incNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("incNextId").getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("incNextId").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getLevel").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getLevel").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setLevel", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, Guild.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setDescription", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertEquals(LocalDate.class, Guild.class.getDeclaredMethod("getCreationDate").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setCreationDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("isRecruiting").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("isRecruiting").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("isRecruiting").getModifiers()));
            assertEquals(boolean.class, Guild.class.getDeclaredMethod("isRecruiting").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("setRecruiting", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("setRecruiting", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("setRecruiting", boolean.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("setRecruiting", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getDaysOfLife").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getDaysOfLife").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getDaysOfLife").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getDaysOfLife").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getMaxMembers").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getMaxMembers").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getMaxMembers").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getMaxMembers").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getMembers").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getMembers").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getMembers").getModifiers()));
            assertEquals(Player[].class, Guild.class.getDeclaredMethod("getMembers").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getNumMembers").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getNumMembers").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getNumMembers").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("getNumMembers").getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("findMember", Player.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("findMember", Player.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("findMember", Player.class).getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("findMember", Player.class).getReturnType());

            assertTrue(Modifier.isPrivate(Guild.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertEquals(int.class, Guild.class.getDeclaredMethod("findFirstEmptySlot").getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("containsMember", Player.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("containsMember", Player.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("containsMember", Player.class).getModifiers()));
            assertEquals(boolean.class, Guild.class.getDeclaredMethod("containsMember", Player.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("addMember", Player.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("addMember", Player.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("addMember", Player.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("addMember", Player.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("removeMember", Player.class).getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("removeMember", Player.class).getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("removeMember", Player.class).getModifiers()));
            assertEquals(void.class, Guild.class.getDeclaredMethod("removeMember", Player.class).getReturnType());

            assertTrue(Modifier.isPublic(Guild.class.getDeclaredMethod("getAverageLevel").getModifiers()));
            assertFalse(Modifier.isStatic(Guild.class.getDeclaredMethod("getAverageLevel").getModifiers()));
            assertFalse(Modifier.isFinal(Guild.class.getDeclaredMethod("getAverageLevel").getModifiers()));
            assertEquals(double.class, Guild.class.getDeclaredMethod("getAverageLevel").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

}
