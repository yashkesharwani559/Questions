import java.util.HashMap;
import java.util.Scanner;

//input:  Enter string 1: rkqodlw
//        Enter string 2: world
// output: true


public class StringScramble {
    static Scanner sc = new Scanner(System.in);

    private static boolean stringScramble(String str1, String str2) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : str2.toCharArray()){
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        
        return true;
    }

    
    public static void main(String[] args){
        System.out.print("Enter string 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter string 2: ");
        String str2 = sc.nextLine();

        System.out.println(stringScramble(str1, str2));
    }    
}
