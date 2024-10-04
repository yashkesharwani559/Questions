import java.util.Scanner;

public class PrimeCheck {
    static Scanner sc = new Scanner(System.in);

    private static boolean primeCheck(int num) {
        String numStr = num + "";
        if (isPrime(num)) {
            return true;
        }

        return permuateAndPrime(numStr, "");
    }

    private static boolean permuateAndPrime(String num, String answer) {
        if (num.length() == 0) {
            return isPrime(Integer.parseInt(answer));
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            String left = num.substring(0, i);
            String right = num.substring(i + 1);

            if (permuateAndPrime(left + right, answer + c)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isPrime(int num) {
        
        if (num < 2) {
            return false;
        }
        else if (num == 2) {
            return true;
        }

        for (int i = 2; i < Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(primeCheck(sc.nextInt()));
    }
}
