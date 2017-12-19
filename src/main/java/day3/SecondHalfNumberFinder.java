package day3;

import java.util.Arrays;

public class SecondHalfNumberFinder {
    private static final int size = 15;
    private static final int start = 7;
    static int[][] a = new int[size][size];
    
    static {
        for (int[] ints : a) {
            Arrays.fill(ints, 0);
        }
    }
    
    public static void main(String[] args) {
        int x = start;
        int y = start;
        int valStart = 1;
        int inc1 = 1;
        int inc2 = 2;
        int inc3 = 3;
        
        a[y][x++] = valStart++;
        
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < inc1; i++) {
                a[y][x] = getNext(x, y--);
            }
            
            for (int i = 0; i < inc2; i++) {
                a[y][x] = getNext(x--, y);
            }
            
            for (int i = 0; i < inc2; i++) {
                a[y][x] = getNext(x, y++);
            }
            
            for (int i = 0; i < inc3; i++) {
                a[y][x] = getNext(x++, y);
            }
            
            inc1 += 2;
            inc2 += 2;
            inc3 += 2;
        }
        
        
        for (int[] integers : a) {
            for (int integer : integers) {
                String numberAsString = String.format("[%06d]", integer);
                System.out.print(numberAsString);
            }
            System.out.println();
        }
    }
    
    public static int getNext(int x, int y) {
        int sum = 0;
        
        sum += a[y    ][x + 1];
        sum += a[y + 1][x    ];
        sum += a[y + 1][x + 1];
        sum += a[y    ][x - 1];
        sum += a[y - 1][x    ];
        sum += a[y + 1][x - 1];
        sum += a[y - 1][x + 1];
        sum += a[y - 1][x - 1];
        
        if (sum > 361527) {
            System.out.println(sum);
        }
        
        return sum;
    }
}
