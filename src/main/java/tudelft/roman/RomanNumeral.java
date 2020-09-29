package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {
        String copy = s.toUpperCase();
        checkInputString(copy);

        int convertedNumber = 0;
        for (int i = 0; i < copy.length(); i++) {
            int currentNumber = map.get(copy.charAt(i));
            int next = i + 1 < copy.length() ? map.get(copy.charAt(i + 1)) : 0;

            if (currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;

    }

    private void checkInputString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                throw new IllegalArgumentException("Please provide valid roman numeral string!");
            }
        }
    }
}
