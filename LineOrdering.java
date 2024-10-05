// here in this problem you will be given an array of strings and each string contains only characters and higher or less than sign in the form like "A>B", "A<B", where A>B means A is in front of B and A<B means A is behind B 
// so you have to return number of the valid combinations we can make using the given input laws
// 

// input: new String[] {"A>B", "A<C", "C<Z"}
// output: 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LineOrdering {

    static Scanner sc = new Scanner(System.in);

    private static int getValidCombinationCount(String[] arr) {
        // Here in this map, key will store the character that will be at the front and
        // value will contain a list that shows that which is behind that character
        HashMap<Character, List<Character>> map = new HashMap<>();
        HashMap<Character, Integer> noOfFrontMap = new HashMap<>();

        HashSet<Character> charSet = new HashSet<>();

        for (String str : arr) {

            char sign = str.charAt(1);

            char key = 'a', val = 'a';

            if (sign == '>') {
                key = str.charAt(0);
                val = str.charAt(2);
            } else if (sign == '<') {
                key = str.charAt(2);
                val = str.charAt(0);
            }

            noOfFrontMap.putIfAbsent(key, 0);

            if (noOfFrontMap.containsKey(val)) {
                noOfFrontMap.put(val, noOfFrontMap.get(val) + 1);
            } else {
                noOfFrontMap.put(val, 1);
            }

            charSet.add(key);
            charSet.add(val);

            if (key == val) {
                return 0;
            }

            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                List<Character> chars = new ArrayList<>();
                chars.add(val);
                map.put(key, chars);
            }
        }

        HashSet<Character> visited = new HashSet<>();
        HashSet<Character> recStack = new HashSet<>();

        for (char c : charSet) {
            if (!visited.contains(c)) {
                if (detectCycle(map, visited, recStack, c)) {
                    return 0;
                }
            }
        }

        int count = findAllTopologicalSorts(map, noOfFrontMap, new ArrayList<Character>(), charSet);

        return count;
    }

    private static int findAllTopologicalSorts(HashMap<Character, List<Character>> adjList,
            HashMap<Character, Integer> inDegree,
            List<Character> sortedOrder, Set<Character> allPeople) {

        boolean found = false;
        int count = 0;

        for (Character p : allPeople) {
            if (inDegree.get(p) == 0 && !sortedOrder.contains(p)) {
                sortedOrder.add(p);
       
                if (adjList.get(p) != null) {   
                    for (char n : adjList.get(p)) {
                        inDegree.put(n, inDegree.get(n) - 1);
                    }
                }

                count += findAllTopologicalSorts(adjList, inDegree, sortedOrder, allPeople);

                sortedOrder.remove(p);

                if (adjList.get(p) != null) {   
                    for (char n : adjList.get(p)) {
                        inDegree.put(n, inDegree.get(n) + 1);
                    }
                }

                found = true;
            }
        }

        if (sortedOrder.size() == allPeople.size()) {
            return 1;
        }

        return found ? count : 0;
    }

    private static boolean detectCycle(HashMap<Character, List<Character>> map, HashSet<Character> visited,
            HashSet<Character> recStack, char p) {

        if (recStack.contains(p)) {
            return true;
        }

        if (visited.contains(p)) {
            return false;
        }

        recStack.add(p);
        visited.add(p);

        if (map.get(p) != null) { 
            for (char c : map.get(p)) {
                if (detectCycle(map, visited, recStack, c)) {
                    return true;
                }
            }
        }

        recStack.remove(p);

        return false;
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of laws: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(getValidCombinationCount(arr));
    }
}
