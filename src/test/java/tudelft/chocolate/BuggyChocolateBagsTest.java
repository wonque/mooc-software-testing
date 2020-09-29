package tudelft.chocolate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BuggyChocolateBagsTest {

    @ParameterizedTest(name = "small={0}, big={1}, goal={2}, expected={3}")
    @CsvSource({"4,1,9,4", "4,1,10,-1", "4,1,7,2"})
    public void testBuggyChocolateBags(int small, int big, int goal, int expected) {
        BuggyChocolateBags victim = new BuggyChocolateBags();
        assertEquals(expected, victim.makeChocolate(small, big, goal));
    }
}