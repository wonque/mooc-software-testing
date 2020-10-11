package tudelft.sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoNumbersSumTest {

    private TwoNumbersSum victim = new TwoNumbersSum();

    @Test
    public void testAddTwoNumbers() {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};

        List<Integer> result = victim.addTwoNumbers(toArrayList(l1), toArrayList(l2));

        assertEquals("[7, 0, 8]", result.toString());
    }

    @Test
    public void testAddTwoNumbers_emptyArrays() {
        List<Integer> result = victim.addTwoNumbers(new ArrayList<>(), new ArrayList<>());

        assertEquals("[]", result.toString());
    }

    @Test
    public void testAddTwoNumbers_firstArrayIsEmpty() {
        int[] array = {5, 6, 4};
        List<Integer> result = victim.addTwoNumbers(new ArrayList<>(), toArrayList(array));

        assertEquals("[4, 6, 5]", result.toString());
    }

    @Test
    public void testAddTwoNumbers_secondArrayEmpty() {
        int[] array = {5, 6, 4};
        List<Integer> result = victim.addTwoNumbers(toArrayList(array), new ArrayList<>());

        assertEquals("[4, 6, 5]", result.toString());
    }

    @Test
    public void testAddTwoNumbers_arraysWithDifferentSizes() {
        int[] array1 = {5, 6, 4};
        int[] array2 = {7, 1};
        List<Integer> result = victim.addTwoNumbers(toArrayList(array1), toArrayList(array2));

        assertEquals("[2, 8, 4]", result.toString());
    }

    @Test
    public void testAddTwoNumbers_arraysWithDifferentSizes2() {
        int[] array1 = {9, 9, 9, 9, 9, 9, 9};
        int[] array2 = {9, 9, 9, 9};
        List<Integer> result = victim.addTwoNumbers(toArrayList(array1), toArrayList(array2));

        assertEquals("[8, 9, 9, 9, 0, 0, 0, 1]", result.toString());
    }

    private ArrayList<Integer> toArrayList(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : array){
            result.add(num);
        }
        return result;
    }

}
