// here you have given an array where the numbers would increase or decrease in starting but after some point they start the reverse operation. So here you have to return the last number of the starting sequence.

import java.util.Scanner;

public class NumberSequence {
    static Scanner sc = new Scanner(System.in);
    
    private static int returnSequence(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return arr[n - 1];
        }

        if (arr[1] > arr[0]) {
            for (int i = 1; i < n; i++) {
                if (arr[i + 1] < arr[i]) {
                    return arr[i];
                }
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (arr[i + 1] > arr[i]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    // input: 1 3 5 8 7 2
    // output: 8
    
    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\n--------------------------------");

        System.out.println(returnSequence(arr));

    }
}
