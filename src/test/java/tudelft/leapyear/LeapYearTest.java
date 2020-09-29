package tudelft.leapyear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTest {

    private final LeapYear ly = new LeapYear();

    @Test
    public void leapYearsThatAreNonCenturialYears() {
        boolean result = ly.isLeapYear(2016);
        assertTrue(result);
    }

    @Test
    public void leapCenturialYears() {
        assertTrue(ly.isLeapYear(2000));
    }

    @Test
    public void nonLeapCenturialYears() {
        assertFalse(ly.isLeapYear(1500));
    }

    @Test
    public void nonLeapYears() {
        assertFalse(ly.isLeapYear(2017));
    }
}
