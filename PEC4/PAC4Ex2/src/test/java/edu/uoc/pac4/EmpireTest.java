package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmpireTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Literals definition")
    void checkLiterals() {
        Empire[] literalsArray = Empire.values();
        List<Empire> literals = Arrays.asList(literalsArray);

        assertEquals(literals.size(), 3);

        assertTrue(literals.contains(Empire.SHINSOO));
        assertTrue(literals.contains(Empire.CHUNJO));
        assertTrue(literals.contains(Empire.JINNO));
    }

}
