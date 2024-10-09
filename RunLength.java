// here you will be given a string as input which has repeated characters one after other. You have to count the number of same characters and then append it to the output string as (count + one_character) . So means you have to output a string

// input: aabbcde
// output: 2a2b1c1d1e

// input: wwwbbw
// 3w2b1w

import java.util.Scanner;

public class RunLength {
    static Scanner sc = new Scanner(System.in);

    private static String runLength(String str){
        if(str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();

        int count = 0;
        char t = str.charAt(0); 

        for  (char c : str.toCharArray() ) {

            if (t != c) {
                sb.append(count + "" + t);
                t = c;
                count = 1;
            }  else {
                count++;
            }
        }
        
        sb.append(count+""+t);

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(runLength(sc.nextLine()));
    }
}
