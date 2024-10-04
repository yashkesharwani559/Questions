import java.util.Scanner;

// you have given the string array having two values x and y index of king and queen on the 8*8 board. There is no other piece on the board. The value of x and y ranges from 1 to 8. So you have to find that is it a check on king or not. If it is not a check return -1 and if it is a check then return the number of spaces he can go to get out of check.

// input: new String{"(1,1)", "(1,4)"}
// output: 3

public class QueenCheck {
    private static Scanner sc = new Scanner(System.in);

    private static int checkRemoveMoves(String[] arr) {  
        String[] q = arr[0].substring(1, arr[0].length()-1).split(",");
        String[] k = arr[1].substring(1, arr[1].length() - 1).split(",");

        int qx = Integer.parseInt(q[0]), qy = Integer.parseInt(q[1]), kx = Integer.parseInt(k[0]),
                ky = Integer.parseInt(k[1]);
 
        if (qx != kx && qy != ky && Math.abs(qx - kx) != Math.abs(qy - ky)) {
           return -1;
        }

                                
        int[][] moves = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0, 1}, {1, -1}, {1,0}, {1,1}};
        int res = 0;
        for (int[] move : moves) {
            int tx = kx + move[0];
            int ty  = ky + move[1];     
            if(tx>0 && tx < 9 && ty>0 && ty<9){
                if (tx != qx && qy != ty && Math.abs(tx - qx) != Math.abs(ty - qy)) {
                    res++;
                }
            }     
        }

        return res;
    }

    public static void main(String[] args){
        String[] arr = new String[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(checkRemoveMoves(arr));
    }
}
