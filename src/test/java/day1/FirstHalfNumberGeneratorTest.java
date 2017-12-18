package day1;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class FirstHalfNumberGeneratorTest {
    
    @Test
    public void calculatesNumbersCorrect() throws Exception {
        compareValueWithCalculatedSum("1122", 3);
        compareValueWithCalculatedSum("1111", 4);
        compareValueWithCalculatedSum("1234", 0);
        compareValueWithCalculatedSum("91212129", 9);
        compareValueWithCalculatedSum("91211231231231231231231112129", 12);
    }
    
    
    private void compareValueWithCalculatedSum(final String numberToCheck, final int expectedValue) throws NoSuchMethodException{
        final FirstHalfNumberGenerator generator = new FirstHalfNumberGenerator(numberToCheck);
        assertEquals(expectedValue, generator.getSum());
    }
}