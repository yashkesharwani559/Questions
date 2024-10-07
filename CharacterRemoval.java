// here you will be given a string array that has two elements. The first one is the string and the second one is the string which contains words according to dictionary that are separated by the ',' . You have to find the minimum characters that should be removed from the string to make it a word of the dictionary. If it is not possible return -1;

import java.util.Scanner;

public class CharacterRemoval {
    static Scanner sc = new Scanner(System.in);

    private static int characterRemoval(String[] arr) {

        String str = arr[0];
        String[] dictionary = arr[1].split(",");

        int minRemovals = Integer.MAX_VALUE;

        for (String word : dictionary) {
            if (isMatched(str, word)) {
                int t = str.length() - word.length();
                minRemovals = Math.min(minRemovals, t);
            }
        }

        return minRemovals == Integer.MAX_VALUE ? -1 : minRemovals;
    }
    
    private static boolean isMatched(String word, String target) {
        int i = 0, j = 0;

        while (i < word.length() && j < target.length()) {
            if (word.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }

    public static void main(String[] args){
        String[] arr = new String[2];
        System.out.println("Enter the strings: ");
        for (int i = 0; i < 2; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(characterRemoval(arr));
    }

}
