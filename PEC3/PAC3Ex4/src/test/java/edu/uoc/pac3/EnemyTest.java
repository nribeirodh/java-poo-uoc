package edu.uoc.pac3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnemyTest {

    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        enemy = new Enemy("Thor", 100, 10, 20, 0, 0);
    }

    @Test
    @Order(1)
    @DisplayName("Constructor assigns values correctly")
    public void testValidConstructor() {
        assertEquals("Thor", enemy.getName());
        assertEquals(100, enemy.getHealth());
        assertEquals(10, enemy.getMinDamage());
        assertEquals(20, enemy.getMaxDamage());
        assertNotNull(enemy.getPosition());
        assertFalse(enemy.isDead());
    }

    @Test
    @Order(2)
    @DisplayName("Throw IllegalArgumentException for null name")
    public void testSetNameNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> enemy.setName(null));
        assertEquals(Enemy.INVALID_NAME, ex.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Throw IllegalArgumentException for empty name")
    public void testSetNameEmpty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> enemy.setName(""));
        assertEquals(Enemy.INVALID_NAME, ex.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName("Throw IllegalArgumentException for excessively long name")
    public void testSetNameTooLong() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> enemy.setName("Name Enemy extra large aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(Enemy.INVALID_NAME, ex.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Set health to a positive value")
    public void testSetHealthPositive() {
        enemy.setHealth(50);
        assertEquals(50, enemy.getHealth());
        assertFalse(enemy.isDead());
    }

    @Test
    @Order(6)
    @DisplayName("Health set to zero results in dead state")
    public void testSetHealthZero() {
        enemy.setHealth(0);
        assertEquals(0, enemy.getHealth());
        assertTrue(enemy.isDead());
    }

    @Test
    @Order(7)
    @DisplayName("Setting negative health results in dead state")
    public void testSetHealthNegative() {
        enemy.setHealth(-10);
        assertEquals(0, enemy.getHealth());
        assertTrue(enemy.isDead());
    }

    @Test
    @Order(8)
    @DisplayName("Throw IllegalArgumentException for invalid minDamage")
    public void testSetMinDamageInvalid() {
        IllegalArgumentException exMin = assertThrows(IllegalArgumentException.class, () -> enemy.setDamage(0, 20));
        assertEquals(Enemy.INVALID_MIN_DAMAGE, exMin.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("Throw IllegalArgumentException for invalid maxDamage")
    public void testSetMaxDamageInvalid() {
        IllegalArgumentException exMax = assertThrows(IllegalArgumentException.class, () -> enemy.setDamage(10, 5));
        assertEquals(Enemy.INVALID_MAX_DAMAGE, exMax.getMessage());
    }

    @Test
    @Order(10)
    @DisplayName("Valid move within max step")
    public void testMoveValid() {
        assertTrue(enemy.move(5, 5));
        assertEquals(5, enemy.getPosition().getX());
        assertEquals(5, enemy.getPosition().getY());
    }

    @Test
    @Order(11)
    @DisplayName("Invalid move beyond max step")
    public void testMoveInvalid() {
        assertFalse(enemy.move(20, 20));
    }

    @Test
    @Order(12)
    @DisplayName("Attack produces damage within expected range")
    public void testAttackInRange() {
        int damage = enemy.attack();
        assertTrue(damage >= 10 && damage <= 20);
    }

    @Test
    @Order(13)
    @DisplayName("Receive damage decreases health correctly")
    public void testReceiveDamage() {
        enemy.receiveDamage(10);
        assertEquals(90, enemy.getHealth());
    }
}
