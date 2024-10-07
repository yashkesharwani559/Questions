import java.util.Scanner;

// you will be given a string that contains two strings separated by space. 1st string has the pattern and 2nd string is the string to check. In the first string, there can + or * or *{N} or a combination of all three. 
// here + means one character, * simply means 3 same characters and *{N} means N same character where N should be minimum 1
// so you have to check the string matches the pattern or not. If it is matched, return true, otherwise false

// input: ++*{5} gheeeee
// output: true

public class WildCardCharacters {
    static Scanner sc = new Scanner(System.in);

    private static boolean matchPattern(String st) {
        String[] t = st.split(" ");
        String pattern = t[0];
        String str = t[1];

        int i = 0, j = 0;
        
        while (i < pattern.length() && j < str.length()) {
            char p = pattern.charAt(i);
            char s = str.charAt(j);
            if (p == '+') {
                if ((s > 'Z' && s < 'a') || s > 'z' || s < 'A') {
                    return false;
                }
                i++;
                j++;
            } else if (p == '*') {
                int c = 3;
                if (i + 1 < pattern.length() && pattern.charAt(i + 1) == '{') {
                    c = pattern.charAt(i + 2) - '0';
                    i += 3;
                }
                for (int a = 1; a < c; a++) {
                    j++;
                    if (j >= str.length() || s != str.charAt(j)) {
                        return false;
                    }
                }
                j++;
                i++;
            }
        }

        if(i == pattern.length() && j == str.length())
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(matchPattern(sc.nextLine()));
    }
}
