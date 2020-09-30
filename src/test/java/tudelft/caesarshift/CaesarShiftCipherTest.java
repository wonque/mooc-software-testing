package tudelft.caesarshift;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CaesarShiftCipherTest {

    private final CaesarShiftCipher victim = new CaesarShiftCipher();

    @Test
    public void testShiftNullMessage() {
        assertThrows(NullPointerException.class, () -> victim.process(null, 4));
    }

    @Test
    public void testShiftMixedCaseLetters() {
        assertEquals("invalid", victim.process("MeSSSaGe", 3));
    }

    @Test
    public void testShiftLettersIfShiftIsZero() {
        assertEquals("abc", victim.process("abc", 0));
    }

    @Test
    public void testNegativeShift() {
        assertEquals("xyz", victim.process("abc", -3));
    }

    @Test
    public void testPositiveShift() {
        assertEquals("def", victim.process("abc", 3));
        assertEquals("abc", victim.process("xyz", 3));
    }

    @Test
    public void testWhitespaceString() {
        assertEquals("invalid", victim.process("   ", 3));
    }

    @Test
    public void testStringContainingWhiteSpace() {
        assertEquals("invalid", victim.process("a b c", 3));
    }

}
