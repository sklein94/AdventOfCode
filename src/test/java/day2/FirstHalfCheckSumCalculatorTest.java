package day2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FirstHalfCheckSumCalculatorTest {
    private static final ArrayList<Integer> firstTestRow = new ArrayList<Integer>() {
        {
            add(5);
            add(1);
            add(9);
            add(5);
        }
    };
    
    private static final ArrayList<Integer> secondTestRow = new ArrayList<Integer>() {
        {
            add(7);
            add(5);
            add(3);
        }
    };
    
    private static final ArrayList<Integer> thirdTestRow = new ArrayList<Integer>() {
        {
            add(2);
            add(4);
            add(6);
            add(8);
        }
    };
    
    
    @Test
    public void selectsHighestNumberCorrect() throws Exception {
        final FirstHalfCheckSumCalculator calculator = new FirstHalfCheckSumCalculator();
        
        assertEquals(9, calculator.getHighestNumber(firstTestRow));
        assertEquals(7, calculator.getHighestNumber(secondTestRow));
        assertEquals(8, calculator.getHighestNumber(thirdTestRow));
    }
    
    @Test
    public void selectsLowestNumberCorrect() throws Exception {
        final FirstHalfCheckSumCalculator calculator = new FirstHalfCheckSumCalculator();
        
        assertEquals(1, calculator.getLowestNumber(firstTestRow));
        assertEquals(3, calculator.getLowestNumber(secondTestRow));
        assertEquals(2, calculator.getLowestNumber(thirdTestRow));
    }
    
    @Test
    public void parsesStringCorrectToArrayList() throws Exception {
        final FirstHalfCheckSumCalculator calculator = new FirstHalfCheckSumCalculator();
        
        assertEquals(firstTestRow, calculator.parseStringToArrayList("5\t1\t9\t5"));
        assertEquals(secondTestRow, calculator.parseStringToArrayList("7\t5\t3"));
        assertEquals(thirdTestRow, calculator.parseStringToArrayList("2\t4\t6\t8"));
    }
    
    @Test
    public void calculatesChecksumCorrect() throws Exception {
        final FirstHalfCheckSumCalculator calculator = new FirstHalfCheckSumCalculator("5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8");

        assertEquals(18, calculator.getChecksum());
    }
    
}