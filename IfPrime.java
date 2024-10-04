// here we have given a number and we have to find that if a number is prime than return true and otherwise false

import java.util.Scanner;

public class IfPrime {
    static Scanner sc = new Scanner(System.in);

    private static boolean isPrime(int num)  {
        if  (num < 2 || num  % 2 ==  0) {
            return false;
        }

        if  (num == 2 || num == 3)
            return true;

        for  (int  i  = 2 ; i <= Math.sqrt(num);  i++) {
            if  (num  % i == 0)
                return false;
        }
        
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPrime(sc.nextInt()));
    }
}
