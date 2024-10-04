// here we have to make one function that takes a number as argument and returns the sum of all multiples of 3 or 5 that are strictly less than that number.

import java.util.Scanner;

public class SumMultiples {
    static Scanner sc = new Scanner(System.in);
    
    private static long getSumMultiples(int num) {
        if (num < 3) {
            return 0;
        }
        long sum = 0;
        for (int i = 3; i < num; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }

        return sum;
    }

    public static void main(String[] args){
        System.out.println("Enter the Number: ");
        int num = sc.nextInt();
        System.out.println(getSumMultiples(num));        
    }    
}
