package day1;

import org.junit.Test;

import static org.junit.Assert.*;

public class SecondHalfNumberGeneratorTest {
    
    @Test
    public void calculatesNumbersCorrect() throws Exception {
        compareValueWithCalculatedSum("1212", 6);
        compareValueWithCalculatedSum("1221", 0);
        compareValueWithCalculatedSum("123425", 4);
        compareValueWithCalculatedSum("123123", 12);
        compareValueWithCalculatedSum("12131415", 4);
    }
    
    
    private void compareValueWithCalculatedSum(final String numberToCheck, final int expectedValue){
        final SecondHalfNumberGenerator generator = new SecondHalfNumberGenerator(numberToCheck);
        assertEquals(expectedValue, generator.getSum());
    }
}