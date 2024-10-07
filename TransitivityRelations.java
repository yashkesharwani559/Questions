// here we will get a string array as argument which will contains a n*n matrix which contains 1 and 0 where at (0,1) is 1 then 0->1 otherwise 0 and 1 are not connected and you can't go from 0 to 1

// here you have to check that if there is a connection of transitivity between nodes, so if all connections are transitive then return a string "transitive" otherwise return the places where wwe have to made 1 to make the connections transitive as (0,1)-(1,2)-... like this.

// input: new String[] {"(1,1,1)", "(0,1,1)", "(0,1,1)"}
// output: transitive

// input: new String[] {"(0,1,0,0)", "(0,0,1,0)", "(0,0,1,1)", "(0,0,0,1)"}
// output: (0,2)-(0,3)-(1,3)


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TransitivityRelations {
    static Scanner sc = new Scanner(System.in);

    private static String transitivityRelations(String[] arr) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (String s : arr) {
            String[] temp = s.substring(1, s.length() - 1).split(",");
            ArrayList<Integer> l = new ArrayList<>();
            for (String t : temp) {
                l.add(Integer.parseInt(t));
            }
            matrix.add(l);
        }

        int n = matrix.size();

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix.get(i).get(j) == 1) {

                    for (int k = 0; k < n; k++) {
                        if (j != k && matrix.get(j).get(k) == 1 && matrix.get(i).get(k) == 0) {
                            set.add("(" + i + "," + k + ")");
                            matrix.get(i).set(k, 1);
                            if (k < j) {
                                j = k - 1;
                            }
                        }
                    }
                }
            }
        }

        if (set.size() == 0)
            return "transitive";

        StringBuilder res = new StringBuilder();

        for (String st : set) {
            res.append(st + "-");
        }

        return res.toString().substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.print("Enter the size of matrix: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(transitivityRelations(arr));
    }
}
