package tudelft.ghappy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GHappyTest {

    private GHappy victim = new GHappy();

    @ParameterizedTest(name = "string={0}, expected={1}")
    @CsvSource({"xxggxx,true", "xxgxx,false", "xxggyygxx,false", "gg,true"})
    public void testMirrorEndsImplementation(String string, boolean expected){
        assertEquals(expected, victim.gHappy(string));
    }
}
