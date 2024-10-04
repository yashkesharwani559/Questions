import java.util.Scanner;

// here we are finding that a given input number comes in the fibonacci series or not

public class MathChallenge {
    public static String mathChallenge(int num){
        if (num == 0 || num == 1) {
            return "yes";
        }
        int a = 0, b = 1;
        while (a <= num) {
            int t = a;
            a = b;
            b = t + b;
            if (a == num) {
                return "yes";
            }
        }
        return "no";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(mathChallenge(sc.nextInt()));

        sc.close();
    }
}
