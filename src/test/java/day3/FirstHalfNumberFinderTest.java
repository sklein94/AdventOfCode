package day3;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstHalfNumberFinderTest {
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    // Test methods
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    @Test
    public void standardTestFromAdventOfCode() throws Exception {
        findTheNumberOfStepsToTake(0, 1);
        findTheNumberOfStepsToTake(3, 12);
        findTheNumberOfStepsToTake(2, 23);
        findTheNumberOfStepsToTake(31, 1024);
    }

    @Test
    public void checkEdges() throws Exception {
        findTheNumberOfStepsToTake(8, 57);
        findTheNumberOfStepsToTake(8, 65);
        findTheNumberOfStepsToTake(8, 73);
        findTheNumberOfStepsToTake(8, 81);


        findTheNumberOfStepsToTake(2, 3);
        findTheNumberOfStepsToTake(2, 5);
        findTheNumberOfStepsToTake(2, 7);
        findTheNumberOfStepsToTake(2, 9);
    }

    @Test
    public void checkDirect() throws Exception {
        findTheNumberOfStepsToTake(2, 11);
        findTheNumberOfStepsToTake(2, 15);
        findTheNumberOfStepsToTake(2, 19);
        findTheNumberOfStepsToTake(2, 23);

        findTheNumberOfStepsToTake(4, 53);
        findTheNumberOfStepsToTake(4, 61);
        findTheNumberOfStepsToTake(4, 69);
        findTheNumberOfStepsToTake(4, 69);
    }

    
    @Test
    public void countsNumbersInRingCorrect() throws Exception {
        testCountNumbersInRing(1, 0);
        testCountNumbersInRing(8, 1);
        testCountNumbersInRing(16, 2);
        testCountNumbersInRing(32, 4);
    }
    
    @Test
    public void countsNumbersInRingsBelowCorrect() throws Exception {
        testCountNumbersInAnyRingBelow(1, 0);
        testCountNumbersInAnyRingBelow(9, 1);
        testCountNumbersInAnyRingBelow(25, 2);
        testCountNumbersInAnyRingBelow(49, 3);
    }
    
    @Test
    public void canFindNumbersRing() throws Exception {
        testFindNumbersRing(0, 1);
        testFindNumbersRing(1, 2);
        testFindNumbersRing(2, 11);
        testFindNumbersRing(3, 28);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    // Test mothods - Private methods
    ///////////////////////////////////////////////////////////////////////////
    
    
    private void testCountNumbersInRing(final int numberExpected, final int numberToCheck) {
        assertEquals(numberExpected, FirstHalfNumberFinder.countNumbersInRing(numberToCheck));
    }
    
    private void testCountNumbersInAnyRingBelow(final int numberExpected, final int numberToCheck) {
        assertEquals(numberExpected, FirstHalfNumberFinder.countNumbersInAnyRingBelow(numberToCheck));
    }
    
    private void testFindNumbersRing(final int numberExpected, final int numberToCheck) {
        assertEquals(numberExpected, FirstHalfNumberFinder.findNumbersRing(numberToCheck));
    }
    
    private void findTheNumberOfStepsToTake(final int numberExpected, final int numberToCheck) {
        assertEquals(numberExpected, FirstHalfNumberFinder.findTheNumberOfStepsToTake(numberToCheck));
    }
}