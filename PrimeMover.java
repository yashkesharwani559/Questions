import java.util.ArrayList;
import java.util.Scanner;

// input: 16
// output: 100

public class PrimeMover {
    static Scanner sc = new Scanner(System.in);

    private static long primeMover(int num) {
        int t = 1;
        if (num == 1)
            return 2;
        else if (num == 2)
            return 3;

        int i = 3;

        while (true) {
            if (isPrime(i)) {
                t++;
            }
            if (t+1 == num) {
                return i;
            }
            i += 2;
        }
    }
    
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        list.add(2);
        list.add(3);
    }

    private static boolean isPrime(int num) {
        for (int a : list) {
            if (num % a == 0) {
                return false;
            }
        }
        list.add(num);
        return true;
    }

    public static void main(String[] args){
        System.out.println(primeMover(sc.nextInt()));
    }
}
