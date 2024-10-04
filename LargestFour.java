import java.util.Scanner;
import java.util.Arrays;

// you have given an array and you have to return the sum of 4 largest numbers of the array. If array has less than 4 elements than return the sum of all the elements of the array

public class LargestFour {
    static Scanner sc = new Scanner(System.in);
    
    private static int largestFour(int[] arr) {
        if (arr.length < 5) {
            int sum = 0;
            for (int a : arr) {
                sum += a;
            }

            return sum;
        }
        
        Arrays.sort(arr);

        int n = arr.length;

        int sum = arr[n - 1] + arr[n - 2] + arr[n - 3] + arr[n - 4];

        return sum;
    }
    
    public static void main(String[] args){
        // int[] arr = { 0, 0, 2, 3, 7, 1 };
        int[] arr = { 1, 1, 1, -5};
        System.out.println(largestFour(arr));
    }
}
