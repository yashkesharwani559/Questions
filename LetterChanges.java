// here you will be given a string as input and you have to return the modified string as output. You have to modify string as the given algorithm. So replacing algo. is like that replace all lowercase character to the next character(i.e c to d, and z to a), and if the new character is a vowel then replace it with the uppercase character

import java.util.Scanner;

// input: hello*3
// output: Ifmmp*3

// input: fun times!
// output: gvO Ujnft!

public class LetterChanges {

    static Scanner sc = new Scanner(System.in);

    private static String letterChanges(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    sb.append("A");
                } else if (c == 'd') {
                    sb.append("E");
                } else if (c == 'h') {
                    sb.append("I");
                } else if (c == 'n') {
                    sb.append("O");
                } else if (c == 't') {
                    sb.append('U');
                } else {
                    c += 1;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(letterChanges(sc.nextLine()));
    }

}
