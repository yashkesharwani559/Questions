// here you have given a string and you have to return boolean value that shows that if given string is a password or not.
// a password has to follow these minimum steps:
// It must have one uppercase and one lowercase character
// it should atleast contain one integer
// It size should be from 8 to 30 characters
// It should not contains any string "password"


// input: tUrkey123!!!!
// output: true

// input: passWord123
// output: false

import java.util.Scanner;
import java.util.regex.Pattern;

public class SimplePassword {
    static Scanner sc = new Scanner(System.in);

    private static boolean simplePassword(String str){
        int n = str.length();

        if(n < 8 || n > 30)
            return false;

        String t = str.toLowerCase();

        if(t.contains("password"))
            return false;

        if (!Pattern.compile("\\d").matcher(str).find())
            return false;

        if (!Pattern.compile("[a-z]").matcher(str).find())
            return false;

        if (!Pattern.compile("[A-Z]").matcher(str).find())
            return false;        
            
        return true;    
    }

    public static void main(String[] args){
        System.out.println(simplePassword(sc.nextLine()));
    }
}
