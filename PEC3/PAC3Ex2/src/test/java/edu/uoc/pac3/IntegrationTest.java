package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

    @Test
    @Order(1)
    @DisplayName("Guild - Add members")
    void testGuildAddMembers() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        Player player1 = new Player("Player1", 80, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player2 = new Player("Player2", 35, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player3 = new Player("Player3", 65, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player4 = new Player("Player4", 40, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player5 = new Player("Player5", 44, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player6 = new Player("Player6", 72, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player7 = new Player("Player7", 88, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player8 = new Player("Player8", 91, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player9 = new Player("Player9", 15, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player10 = new Player("Player10", 5, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player11 = new Player("Player11", 1, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player12 = new Player("Player12", 13, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player13 = new Player("Player13", 99, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player14 = new Player("Player14", 71, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player15 = new Player("Player15", 60, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player16 = new Player("Player16", 75, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player17 = new Player("Player17", 25, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player18 = new Player("Player18", 34, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player19 = new Player("Player19", 55, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player20 = new Player("Player20", 51, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player21 = new Player("Player21", 8, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player playerNoPet = new Player("PlayerNoPet", 1, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric");

        guild.addMember(player1);

        assertEquals(1, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertFalse(guild.containsMember(player2));
        assertEquals(player1, guild.getMembers()[0]);

        guild.addMember(player2);

        assertEquals(2, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertFalse(guild.containsMember(player3));
        assertFalse(guild.containsMember(player4));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);

        guild.addMember(player4);
        guild.addMember(player3);

        assertEquals(4, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertTrue(guild.containsMember(player4));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);
        assertEquals(player4, guild.getMembers()[2]);
        assertEquals(player3, guild.getMembers()[3]);

        for (int i = 4; i < guild.getNumMembers(); i++) {
            assertNull(guild.getMembers()[i]);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> guild.containsMember(null));
        assertEquals(Guild.MEMBER_NULL, exception.getMessage());

        exception = assertThrows(NullPointerException.class, () -> guild.containsMember(new Player("NoPet", 1, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric")));
        assertEquals(Guild.MEMBER_NO_PET, exception.getMessage());

        exception = assertThrows(NullPointerException.class, () -> guild.addMember(null));
        assertEquals(Guild.MEMBER_NULL, exception.getMessage());

        exception = assertThrows(NullPointerException.class, () -> guild.addMember(playerNoPet));
        assertEquals(Guild.MEMBER_NO_PET, exception.getMessage());

        assertEquals(4, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertTrue(guild.containsMember(player4));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);
        assertEquals(player4, guild.getMembers()[2]);
        assertEquals(player3, guild.getMembers()[3]);

        for (int i = 4; i < guild.getNumMembers(); i++) {
            assertNull(guild.getMembers()[i]);
        }

        exception = assertThrows(IllegalArgumentException.class, () -> guild.addMember(player1));
        assertEquals(Guild.MEMBER_ALREADY_EXISTS, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> guild.addMember(player4));
        assertEquals(Guild.MEMBER_ALREADY_EXISTS, exception.getMessage());

        assertEquals(4, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertTrue(guild.containsMember(player4));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);
        assertEquals(player4, guild.getMembers()[2]);
        assertEquals(player3, guild.getMembers()[3]);

        for (int i = 4; i < guild.getNumMembers(); i++) {
            assertNull(guild.getMembers()[i]);
        }

        guild.addMember(player5);
        guild.addMember(player6);
        guild.addMember(player7);
        guild.addMember(player8);
        guild.addMember(player9);
        guild.addMember(player10);
        guild.addMember(player11);
        guild.addMember(player12);
        guild.addMember(player13);
        guild.addMember(player14);
        guild.addMember(player15);
        guild.addMember(player16);
        guild.addMember(player17);
        guild.addMember(player18);
        guild.addMember(player19);
        guild.addMember(player20);

        assertEquals(20, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertTrue(guild.containsMember(player4));
        assertTrue(guild.containsMember(player5));
        assertTrue(guild.containsMember(player6));
        assertTrue(guild.containsMember(player7));
        assertTrue(guild.containsMember(player8));
        assertTrue(guild.containsMember(player9));
        assertTrue(guild.containsMember(player10));
        assertTrue(guild.containsMember(player11));
        assertTrue(guild.containsMember(player12));
        assertTrue(guild.containsMember(player13));
        assertTrue(guild.containsMember(player14));
        assertTrue(guild.containsMember(player15));
        assertTrue(guild.containsMember(player16));
        assertTrue(guild.containsMember(player17));
        assertTrue(guild.containsMember(player18));
        assertTrue(guild.containsMember(player19));
        assertTrue(guild.containsMember(player20));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);
        assertEquals(player4, guild.getMembers()[2]);
        assertEquals(player3, guild.getMembers()[3]);
        assertEquals(player5, guild.getMembers()[4]);
        assertEquals(player6, guild.getMembers()[5]);
        assertEquals(player7, guild.getMembers()[6]);
        assertEquals(player8, guild.getMembers()[7]);
        assertEquals(player9, guild.getMembers()[8]);
        assertEquals(player10, guild.getMembers()[9]);
        assertEquals(player11, guild.getMembers()[10]);
        assertEquals(player12, guild.getMembers()[11]);
        assertEquals(player13, guild.getMembers()[12]);
        assertEquals(player14, guild.getMembers()[13]);
        assertEquals(player15, guild.getMembers()[14]);
        assertEquals(player16, guild.getMembers()[15]);
        assertEquals(player17, guild.getMembers()[16]);
        assertEquals(player18, guild.getMembers()[17]);
        assertEquals(player19, guild.getMembers()[18]);
        assertEquals(player20, guild.getMembers()[19]);

        exception = assertThrows(IllegalStateException.class, () -> guild.addMember(player21));
        assertEquals(Guild.INVALID_MAX_MEMBERS, exception.getMessage());

        assertEquals(20, guild.getNumMembers());
    }

    @Test
    @Order(2)
    @DisplayName("Guild - Remove members")
    void testGuildRemoveMembers() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        Player player1 = new Player("Player1", 80, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player2 = new Player("Player2", 35, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player3 = new Player("Player3", 65, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player4 = new Player("Player4", 40, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);

        Exception exception = assertThrows(NullPointerException.class, () -> guild.removeMember(null));
        assertEquals(Guild.MEMBER_NULL, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> guild.removeMember(player1));
        assertEquals(Guild.MEMBER_NOT_FOUND, exception.getMessage());

        guild.addMember(player1);

        exception = assertThrows(IllegalArgumentException.class, () -> guild.removeMember(player2));
        assertEquals(Guild.MEMBER_NOT_FOUND, exception.getMessage());

        guild.addMember(player2);

        assertEquals(2, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player2));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player2, guild.getMembers()[1]);

        guild.removeMember(player2);

        assertEquals(1, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertFalse(guild.containsMember(player2));
        assertEquals(player1, guild.getMembers()[0]);
        assertNull(guild.getMembers()[1]);

        exception = assertThrows(IllegalArgumentException.class, () -> guild.removeMember(player2));
        assertEquals(Guild.MEMBER_NOT_FOUND, exception.getMessage());

        guild.addMember(player3);

        assertEquals(2, guild.getNumMembers());
        assertTrue(guild.containsMember(player1));
        assertTrue(guild.containsMember(player3));
        assertEquals(player1, guild.getMembers()[0]);
        assertEquals(player3, guild.getMembers()[1]);

        guild.removeMember(player1);

        assertEquals(1, guild.getNumMembers());
        assertFalse(guild.containsMember(player1));
        assertFalse(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertNull(guild.getMembers()[0]);
        assertEquals(player3, guild.getMembers()[1]);

        guild.addMember(player4);

        assertEquals(2, guild.getNumMembers());
        assertFalse(guild.containsMember(player1));
        assertFalse(guild.containsMember(player2));
        assertTrue(guild.containsMember(player3));
        assertTrue(guild.containsMember(player4));
        assertEquals(player4, guild.getMembers()[0]);
        assertEquals(player3, guild.getMembers()[1]);

        for (int i = 2; i < guild.getNumMembers(); i++) {
            assertNull(guild.getMembers()[i]);
        }
    }

    @Test
    @Order(3)
    @DisplayName("Guild - Average level")
    void testGuildAverageLevel() {
        Guild guild = new Guild("TheDragonS", 20, "The best of the Kingdom", LocalDate.of(2010, 6, 22), true, 20);

        Player player1 = new Player("Player1", 80, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player2 = new Player("Player2", 35, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player3 = new Player("Player3", 65, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);
        Player player4 = new Player("Player4", 40, LocalDate.of(2010, 6, 22), 0, 0, 0.0, 0.0, 0.0, "Chivalric", "BaoBao", 1, LocalDate.now(), 0, 0, false);

        assertEquals(0.0, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.addMember(player1);
        assertEquals(80.0, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.addMember(player2);
        assertEquals(57.5, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.addMember(player3);
        assertEquals(60.0, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.addMember(player4);
        assertEquals(55.0, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.removeMember(player1);
        assertEquals(46.67, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.removeMember(player2);
        assertEquals(52.5, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.addMember(player1);
        assertEquals(61.67, (double) Math.round(guild.getAverageLevel() * 100) / 100);

        guild.removeMember(player1);
        guild.removeMember(player3);
        guild.removeMember(player4);
        assertEquals(0.0, guild.getAverageLevel());
    }

}
