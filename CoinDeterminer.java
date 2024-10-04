// here in this problem we have coins of 1,5,7,9,11 and we have given a number as input and we have to find minimum number of coins required to make that value

import java.util.Scanner;

public class CoinDeterminer {
    static Scanner sc = new Scanner(System.in);
    
    private static int coinDeterminer(int num){
        int[] coins = {1,5,7,9,11};
        int[] res = new int[num + 1];

        res[0] = 0; 

        for (int i = 1; i <= num; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    res[i] = Math.min(res[i], res[i - coin] + 1);
                }else{
                    break;
                }
            }
        }
        
        return res[num];
    }
    public static void main(String[] args){
        System.out.println(coinDeterminer(sc.nextInt()));
    }
}
