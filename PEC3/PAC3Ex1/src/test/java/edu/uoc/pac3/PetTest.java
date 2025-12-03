package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    @Test
    @Order(4)
    @DisplayName("Pet creation - Valid parameters")
    void testCreatePet() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);

        assertNotNull(pet);
        assertEquals("BaoBao", pet.getName());
        assertEquals(1, pet.getLevel());
        assertEquals(LocalDate.now(), pet.getBirthdate());
        assertEquals(20, pet.getLoyalty());
        assertEquals(100, pet.getStamina());
        assertFalse(pet.isAggressive());
    }

    @Test
    @Order(5)
    @DisplayName("Pet creation - Valid name")
    void testCreatePetValidName() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);
        assertEquals("BaoBao", pet.getName());

        pet = new Pet("Rufus", 1, LocalDate.now(), 20, 100, false);
        assertEquals("Rufus", pet.getName());

        pet = new Pet("Khan", 1, LocalDate.now(), 20, 100, false);
        assertEquals("Khan", pet.getName());

        pet = new Pet("A".repeat(3), 1, LocalDate.now(), 20, 100, false);
        assertEquals("A".repeat(3), pet.getName());

        pet = new Pet("A".repeat(20), 1, LocalDate.now(), 20, 100, false);
        assertEquals("A".repeat(20), pet.getName());

        pet = new Pet("  A A   ", 1, LocalDate.now(), 20, 100, false);
        assertEquals("A A", pet.getName());
    }

    @Test
    @Order(6)
    @DisplayName("Pet creation - Invalid name")
    void testCreatePetInvalidName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Pet("", 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet(null, 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("A", 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("A".repeat(21), 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("    ".repeat(3), 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet(" AA ", 1, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_NAME, ex.getMessage());
    }

    @Test
    @Order(7)
    @DisplayName("Pet creation - Valid level")
    void testCreatePetValidLevel() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);
        assertEquals(1, pet.getLevel());

        pet = new Pet("BaoBao", 30, LocalDate.now(), 20, 100, false);
        assertEquals(30, pet.getLevel());

        pet = new Pet("BaoBao", 60, LocalDate.now(), 20, 100, false);
        assertEquals(60, pet.getLevel());
    }

    @Test
    @Order(8)
    @DisplayName("Pet creation - Invalid level")
    void testCreatePetInvalidLevel() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 0, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_LEVEL, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 61, LocalDate.now(), 20, 100, false));
        assertEquals(Pet.INVALID_LEVEL, ex.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("Pet creation - Valid birthdate")
    void testCreatePetValidBirthdate() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);
        assertEquals(LocalDate.now(), pet.getBirthdate());

        pet = new Pet("BaoBao", 1, LocalDate.now().minusDays(1), 20, 100, false);
        assertEquals(LocalDate.now().minusDays(1), pet.getBirthdate());

        pet = new Pet("BaoBao", 1, LocalDate.now().minusYears(1), 20, 100, false);
        assertEquals(LocalDate.now().minusYears(1), pet.getBirthdate());
    }

    @Test
    @Order(10)
    @DisplayName("Pet creation - Invalid birthdate")
    void testCreatePetInvalidBirthdate() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, null, 20, 100, false));
        assertEquals(Pet.INVALID_BIRTHDATE, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now().plusDays(1), 20, 100, false));
        assertEquals(Pet.INVALID_BIRTHDATE, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now().plusYears(1), 20, 100, false));
        assertEquals(Pet.INVALID_BIRTHDATE, ex.getMessage());
    }

    @Test
    @Order(11)
    @DisplayName("Pet creation - Valid stamina")
    void testCreatePetValidStamina() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 0, false);
        assertEquals(0, pet.getStamina());

        pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 50, false);
        assertEquals(50, pet.getStamina());

        pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);
        assertEquals(100, pet.getStamina());
    }

    @Test
    @Order(12)
    @DisplayName("Pet creation - Invalid stamina")
    void testCreatePetInvalidStamina() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now(), 20, -1, false));
        assertEquals(Pet.INVALID_STAMINA, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now(), 20, 101, false));
        assertEquals(Pet.INVALID_STAMINA, ex.getMessage());
    }

    @Test
    @Order(13)
    @DisplayName("Pet creation - Valid loyalty")
    void testCreatePetValidLoyalty() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 0, 100, false);
        assertEquals(0, pet.getLoyalty());

        pet = new Pet("BaoBao", 1, LocalDate.now(), 50, 100, false);
        assertEquals(50, pet.getLoyalty());

        pet = new Pet("BaoBao", 1, LocalDate.now(), 100, 100, false);
        assertEquals(100, pet.getLoyalty());
    }

    @Test
    @Order(14)
    @DisplayName("Pet creation - Invalid loyalty")
    void testCreatePetInvalidLoyalty() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now(), -1, 100, false));
        assertEquals(Pet.INVALID_LOYALTY, ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> new Pet("BaoBao", 1, LocalDate.now(), 101, 100, false));
        assertEquals(Pet.INVALID_LOYALTY, ex.getMessage());
    }

    @Test
    @Order(15)
    @DisplayName("Pet creation - Aggressive")
    void testCreatePetAggressive() {
        Pet pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, false);
        assertFalse(pet.isAggressive());

        pet = new Pet("BaoBao", 1, LocalDate.now(), 20, 100, true);
        assertTrue(pet.isAggressive());
    }

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        //check attribute fields
        assertEquals(14, Pet.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Pet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("INVALID_NAME").getType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("INVALID_LEVEL").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("INVALID_LEVEL").getType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredField("INVALID_BIRTHDATE").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("INVALID_BIRTHDATE").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("INVALID_BIRTHDATE").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("INVALID_BIRTHDATE").getType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredField("INVALID_LOYALTY").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("INVALID_LOYALTY").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("INVALID_LOYALTY").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("INVALID_LOYALTY").getType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredField("INVALID_STAMINA").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("INVALID_STAMINA").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("INVALID_STAMINA").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("INVALID_STAMINA").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("MAX_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isStatic(Pet.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertTrue(Modifier.isFinal(Pet.class.getDeclaredField("MAX_LEVEL").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("MAX_LEVEL").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("level").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("level").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("level").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("birthdate").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("birthdate").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("birthdate").getModifiers()));
            assertEquals(LocalDate.class, Pet.class.getDeclaredField("birthdate").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("loyalty").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("loyalty").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("loyalty").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("loyalty").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("stamina").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("stamina").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("stamina").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredField("stamina").getType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredField("aggressive").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredField("aggressive").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredField("aggressive").getModifiers()));
            assertEquals(boolean.class, Pet.class.getDeclaredField("aggressive").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    void checkConstructorSanity() {
        //check constructors
        assertEquals(1, Pet.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Pet.class.getDeclaredConstructor(String.class, int.class, LocalDate.class, int.class, int.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        //check methods, parameters and return types
        assertEquals(6, Arrays.stream(Pet.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Pet.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("getLevel").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("getLevel").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredMethod("getLevel").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setLevel", int.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setLevel", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("getBirthdate").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("getBirthdate").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("getBirthdate").getModifiers()));
            assertEquals(LocalDate.class, Pet.class.getDeclaredMethod("getBirthdate").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setBirthdate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setBirthdate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setBirthdate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setBirthdate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("getLoyalty").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("getLoyalty").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("getLoyalty").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredMethod("getLoyalty").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setLoyalty", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setLoyalty", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setLoyalty", int.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setLoyalty", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("getStamina").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("getStamina").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("getStamina").getModifiers()));
            assertEquals(int.class, Pet.class.getDeclaredMethod("getStamina").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setStamina", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setStamina", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setStamina", int.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setStamina", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Pet.class.getDeclaredMethod("isAggressive").getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("isAggressive").getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("isAggressive").getModifiers()));
            assertEquals(boolean.class, Pet.class.getDeclaredMethod("isAggressive").getReturnType());

            assertTrue(Modifier.isPrivate(Pet.class.getDeclaredMethod("setAggressive", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Pet.class.getDeclaredMethod("setAggressive", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Pet.class.getDeclaredMethod("setAggressive", boolean.class).getModifiers()));
            assertEquals(void.class, Pet.class.getDeclaredMethod("setAggressive", boolean.class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

}
