import java.util.Scanner;

// here you will be given two numbers and you have to return the HCF or greatest common divisor of both numbers

public class Division {

    static private Scanner sc = new Scanner(System.in);

    private static int findGCD(int a, int b){
        if(b == 0) return a;

        return findGCD(b, a%b);
    }
   
    public static void main(String[] args){
        System.out.println(findGCD(sc.nextInt(),  sc.nextInt()));
    }
}
