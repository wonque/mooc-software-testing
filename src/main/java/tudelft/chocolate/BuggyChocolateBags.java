package tudelft.chocolate;

public class BuggyChocolateBags {

    public int makeChocolate(int small, int big, int goal) {
        int maxBigBoxes = goal / 5;
        int bigBoxesWeCanUse = maxBigBoxes < big ? maxBigBoxes : big;
        goal -= (bigBoxesWeCanUse * 5);
        if (small < goal)
            return -1;
        return goal;
    }
}
