package day2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SecondHalfCheckSumCalculatorTest {
    
    private static final ArrayList<Integer> firstTestRow = new ArrayList<Integer>() {
        {
            add(5);
            add(9);
            add(2);
            add(8);
        }
    };
    
    private static final ArrayList<Integer> secondTestRow = new ArrayList<Integer>() {
        {
            add(9);
            add(4);
            add(7);
            add(3);
        }
    };
    
    private static final ArrayList<Integer> thirdTestRow = new ArrayList<Integer>() {
        {
            add(3);
            add(8);
            add(6);
            add(5);
        }
    };
    
    @Test
    public void parsesStringCorrectToArrayList() throws Exception {
        final SecondHalfCheckSumCalculator calculator = new SecondHalfCheckSumCalculator();
        
        assertEquals(firstTestRow, calculator.parseStringToArrayList("5\t9\t2\t8"));
        assertEquals(secondTestRow, calculator.parseStringToArrayList("9\t4\t7\t3"));
        assertEquals(thirdTestRow, calculator.parseStringToArrayList("3\t8\t6\t5"));
    }
    
    @Test
    public void calculatesChecksumCorrect() throws Exception {
        final SecondHalfCheckSumCalculator calculator = new SecondHalfCheckSumCalculator("5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5");
        
        assertEquals(9, calculator.getChecksum());
    }
    
}