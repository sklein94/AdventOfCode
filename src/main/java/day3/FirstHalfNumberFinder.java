package day3;

public class FirstHalfNumberFinder {
    public static void main(String[] args) {
        System.out.println(findTheNumberOfStepsToTake(361527));
    }
    
    public static int moveBy(final int times, final int startingDifference) {
        int add = startingDifference;
        int interval = 8;
        int sum = 1;
        for (int i = 0; i < times; i++) {
            sum += add;
            add += interval;
        }
        return sum;
    }
    
    public static int countNumbersInAnyRingBelow(final int ring) {
        if (ring == 0) return 1;
        int numbers = 1;
        int ringNumbers = 8;
        for (int i = 1; i <= ring; i++) {
            numbers += ringNumbers;
            ringNumbers += 8;
        }
        return numbers;
    }
    
    public static int countNumbersInRing(final int ring) {
        if (ring == 0) return 1;
        return ring * 8;
    }
    
    public static int findNumbersRing(final int number) {
        if (number == 1) return 0;
        int numberCompare = 0;
        int ring = 0;
        while (numberCompare < number) {
            numberCompare = countNumbersInAnyRingBelow(ring) + countNumbersInRing(ring + 1);
            if (numberCompare >= number) {
                return ring + 1;
            }
            ring++;
        }
        return 0;
    }
    
    public static int findTheNumberOfStepsToTake(final int number) {
        final int ring = findNumbersRing(number);
        if (numberBetweenEdges(2, 4, ring, number)) {
            return ring + Math.abs(moveBy(ring, 3) - number);
        }
        else if (numberBetweenEdges(4, 6, ring, number)) {
            return ring + Math.abs(moveBy(ring, 5) - number);
        }
        else if (numberBetweenEdges(6, 8, ring, number)) {
            return ring + Math.abs(moveBy(ring, 7) - number);
        }
        else if (numberBetweenEdges(8, 2, ring, number)) {
            return ring + Math.abs(moveBy(ring, 1) - number);
        }
        return -1;
    }
    
    public static boolean numberBetweenEdges(final int edgeIdA, final int edgeIdB, final int ring, final int number) {
        final boolean conditionA = number >= moveBy(ring, edgeIdA) && number <= moveBy(ring, edgeIdB);
        final boolean conditionB = number <= moveBy(ring, edgeIdA) && number >= moveBy(ring, edgeIdB);
        final boolean conditionC = (number <= moveBy(ring, edgeIdB) || number == moveBy(ring, edgeIdA)) && edgeIdA == 8 && edgeIdB == 2;
        return conditionA || conditionB || conditionC;
    }
}
