package tudelft.mirror;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MirrorTest {

    @ParameterizedTest(name = "string={0}, expected={1}")
    @CsvSource({"abXYZba,ab", "abca,a", "aba,a", "abc,''"})
    public void testMirrorEndsImplementation(String string, String expected){
        Mirror victim = new Mirror();
        assertEquals(expected, victim.mirrorEnds(string));
    }
 }
