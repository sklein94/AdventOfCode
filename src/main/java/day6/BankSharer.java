package day6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BankSharer {
    private static final String input =
            "10\t3\t15\t10\t5\t15\t5\t15\t9\t2\t5\t8\t5\t2\t3\t6";
//    private static final String input =
//            "0\t2\t7\t0";
    
    
    public static final ArrayList<String> saver = new ArrayList<String>();
    
    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for (String s : input.split("\t")) {
            list.add(Integer.parseInt(s));
        }
        
        saver.add(list.toString());
        
        int count = 0;
        while (true) {
            int index = getIndexWithHighestNumber(list);
            int value = list.get(index);
            int shareNext = index + 1;
            int shareValue = value / list.size();
            if (shareValue == 0) shareValue = 1;
            list.set(index, 0);
            
            while ((value - shareValue) > 0) {
                try {
                    list.set(shareNext, list.get(shareNext) + shareValue);
                    value -= shareValue;
                }
                catch (IndexOutOfBoundsException e) {
                    shareNext = 0;
                    list.set(shareNext, list.get(shareNext) + shareValue);
                    value -= shareValue;
                }
                shareNext++;
            }
            
            try {
                list.set(shareNext, list.get(shareNext) + value);
            }
            catch (IndexOutOfBoundsException e){
                shareNext = 0;
                list.set(shareNext, list.get(shareNext) + value);
            }
            
            count++;
            
            if (saver.contains(list.toString())){
                System.out.println(count);
                System.out.println(count-saver.indexOf(list.toString()));
                break;
            }
            else{
                saver.add(list.toString());
            }
    
            
        }
    }
    
    
    public static int getIndexWithHighestNumber(final ArrayList<Integer> list) {
        final ArrayList<Integer> test = (ArrayList<Integer>) list.clone();
        Collections.sort(test);
        return list.indexOf(test.get(test.size() - 1));
    }
}
