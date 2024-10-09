// here we will be given a encrypted string as input and we have to output the decrypted string
// Rules of encryption are :
// if decrypted string contains "am" then encrypted string contains "bcdefghijkl"
// if decrypted string contains "oc" then encrypted string contains "nmlkjihgfed"
// the input string will contain only lowercase characters
// if only one character contains between two characters like "ac" then "bR" is the encrypted version of string "ac" and if string is "ca" then the encrypted string will be "bL" which means that string is reverse
// If the decrypted string contains zero characters in between like "ab" then it encrypted string will be "abS" and if string is "aba" then the encrypted string would be "abSbaS"
// IF the decrypted string contains repeated characters like "acc" then the encrypted string would be "bRcN"


// input: bcdefghijklmnopqrstN
// output: att

// input: cdefghijklmnnmlkjihgfedcb
// output: boa

import java.util.Scanner;

public class AlphabetRunEncryption {
    static Scanner sc = new Scanner(System.in);
    
    private static String alphabetRunEncryption(String encString) {

        if (encString.length() == 0)
            return encString;

        StringBuilder res = new StringBuilder();
        int i = 0, n = encString.length(), increase = 0;
        boolean flag = true;
        char c = 'a';

        while (i < n) {

            c = encString.charAt(i);

            if (i + 1 < n) {

                char t = encString.charAt(i + 1);

                if (t == 'R') {
                    t = (char) (encString.charAt(i) - 1);
                    res.append(t);
                    t += 2;
                    res.append(t);
                    i += 2;
                } else if (t == 'L') {
                    t = (char) (encString.charAt(i) + 1);
                    res.append(t);
                    t -= 2;
                    res.append(t);
                    i += 2;
                } else if (t == 'N') {
                    res.append(encString.charAt(i));
                    i += 2;
                } else if (i + 2 < n && encString.charAt(i + 2) == 'S') {
                    res.append(encString.charAt(i) + encString.charAt(i + 1));
                    i += 3;
                } else {
                    char t1 = encString.charAt(i + 1);

                    if (flag) {
                        if (i - 1 > -1 && encString.charAt(i - 1) == c) {
                            flag = false;
                        } else if (t1 < c) {
                            c += 1;
                            res.append(c);
                            increase = -1;
                        } else if (t1 > c) {
                            c -= 1;
                            res.append(c);
                            increase = 1;
                        }

                        flag = false;
                    } else {
                        if (t1 == c || ((t1 > c || t1 < c) && i + 2 < n && (encString.charAt(i + 2) == 'L'
                                || encString.charAt(i + 2) == 'R' || encString.charAt(i + 2) == 'N'))) {
                            if (increase == 1) {
                                c += 1;
                                res.append(c);
                                increase = -1;
                            } else if (increase == -1) {
                                c -= 1;
                                res.append(c);
                                increase = 1;
                            }
                            flag = true;
                        }
                    }
                    i++;
                }
            } else {
                i++;
            }
        }
  
        c = encString.charAt(n - 1);
  
        if(c != 'N' && c != 'L' && c != 'R' && c != 'S'){
            if(increase == 1){
                c += 1;
            }else if( increase == -1){
                c -= 1;
            }
            res.append(c);
        }

        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(alphabetRunEncryption(sc.nextLine()));
    }
}
