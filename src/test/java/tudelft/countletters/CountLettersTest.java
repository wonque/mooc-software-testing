package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void testFirstWordEndsWithR() {
        int words = new CountLetters().count("order|police");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void testFirstWordWithRLastWithS() {
        int words = new CountLetters().count("order|assumptions");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void testFirstWordWithSLastWithR() {
        int words = new CountLetters().count("assumptions|order");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void testNotAWordsInput() {
        int words = new CountLetters().count("*|%");
        Assertions.assertEquals(0, words);
    }

}