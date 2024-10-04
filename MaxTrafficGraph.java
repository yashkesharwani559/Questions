// here in this problem you will get a undirected graph and get the input in the form of string array as a adjacency list. You have to find the maximum Traffic on each city that have roads to another city.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// input: ["1:[5]", "4:[5]", "3:[5]", "5:[1,4,3,2]", "2:[5,15,7]", "7:[2,8]", "8:[7,38]", "15:[2]", "38:[8]"]

// output: 1:82,2:53,3:80,4:79,5:70,7:46,8:38,15:68,38:45

public class MaxTrafficGraph {

    static Scanner sc = new Scanner(System.in);
    
    private static String getMaxTraffic(String[] input) {

        // first task is to create an adjacency list using the input string

        Map<Integer, List<Integer>> graph = new TreeMap<>();

        for (String str : input) {
            String[] t = str.split(":");

            int city = Integer.parseInt(t[0]);
            String[] t1 = t[1].split("\\[");
            String neighbours = t1[1].substring(0, t1[1].length() - 1);

            List<Integer> list = new ArrayList<>();
            for (String neighbour : neighbours.split(",")) {
                if (neighbour.length() == 0) {
                    continue;
                }
                list.add(Integer.parseInt(neighbour));
            }

            graph.put(city, list);
        }

        System.out.println(graph);

        StringBuilder res = new StringBuilder();

        int sum = 0;

        for (int a : graph.keySet()) {
            sum += a;
        }

        for (Integer city : graph.keySet()) {
            List<Integer> list = graph.get(city);
            if (list.size() == 1) {
                res.append(city + ":" + (sum - city) + ",");
            } else {
                res.append(city + ":" + (getMaxTraffic(city, city, graph)) + ",");
            }
        }

        return res.toString().substring(0, res.length() - 1);
    }
    
    private static int getMaxTraffic(int city, int temp, Map<Integer, List<Integer>> graph) {

        int traffic = 0;

        for (int a : graph.get(temp)) {
            int t = dfs(temp, a, graph);
            if (t > traffic) {
                traffic = t;
            }
        }

        return traffic;
    }
    
    private static int dfs(int city, int temp, Map<Integer, List<Integer>> graph) {
        
        int traffic = 0;
        
        for (int a : graph.get(temp)) {
            if (a == city)
                continue;
            traffic += dfs(temp, a, graph);
        }
        
        traffic += temp;

        return traffic;
    }

    public static void main(String[] args) {
        
        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();

        String[] input = new String[n];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        System.out.println(getMaxTraffic(input));
    }
}
