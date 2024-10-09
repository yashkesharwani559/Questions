// here in this question we will get a number as input and return string true if the number is a prime number otherwise return string false
// the number can be of range 1 to 2^16

// input: 1571
// output: true

// input: 1535
// output: false

import java.util.Arrays;
import java.util.Scanner;

public class PrimeTime {
    static Scanner sc = new Scanner(System.in);

    private static String primeTime(int num) {

        if(num < 2) 
            return "false";
        else if(num == 2)
            return "true";
        else if(num % 2 == 0)
            return "false";

        boolean[] arr = new boolean[num+1];

        Arrays.fill(arr, true);

        for (int i = 3; i <= num; i += 2) {

            if (arr[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    arr[j] = false;
                }
            }
        }
        
        return arr[num] ? "true" : "false";

    }

    public static void main(String[] args){
        System.out.println(primeTime(sc.nextInt()));
    }
}
