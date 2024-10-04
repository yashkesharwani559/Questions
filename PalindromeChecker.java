// write a program that checks that if a given string is palindrome or not. You have not to consider spaces in between the words.

import java.util.Scanner;

public class PalindromeChecker {
    static Scanner sc = new Scanner(System.in);
    
    private static String isPalindrome(String s)  {
        if (s.length() == 0 | s.length() == 1){
            return "yes";
        }
        
        s = s.replaceAll("\\s+", "").toLowerCase();

        System.out.println(s);

        int start = 0, end = s.length()-1;

        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)){
                return "no";
            }
        }
        
        return "yes";
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(sc.nextLine()));
    }
}
