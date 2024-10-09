// here you will be given a number as input and you have to return factorial of that number

// here I am using the concept of dynamic programming (memoization)

// input: 5
// output: 120

import java.util.Scanner;

public class FirstFactorial {
    static Scanner sc = new Scanner(System.in);

    private static long firstFactorial(int num) {
        if(num == 0 || num == 1)
            return 1;

        int prev = 1;

        for (int i = 2; i <= num; i++) {
            prev *= i;
        }

        return prev;
    }
    
    public static void main(String[] args) {
        System.out.println(firstFactorial(sc.nextInt()));    
    }
}
