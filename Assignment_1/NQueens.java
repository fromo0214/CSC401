package Assignment_1;
import java.util.List;
import java.util.ArrayList;
//Fernando Romo CSC401-01 N-Queens Problem w/o Backtracking
public class NQueens{

    


    public static void main(String[] args) {

    //     int n = 4;
    //     int board[][] = new int[n][n];

    //     displayBoard(board);

    //     int x,y,z,w;
    //     for(int q1 = 1; q1 <= 4; q1++){
    //         x = q1;
    //         for(int q2 = 5; q2 <= 8; q2++){
    //             if(!solution(x, q2)){
    //                 y = q2;
    //                 for(int q3 = 9; q3 <= 12; q3++){
    //                     if(!solution(x,q3) && !solution(y, q3)){
    //                         z = q3;
    //                         for(int q4 = 14; q4 <=16; q4++){
    //                             if(!solution(x, q4) && !solution(y, q4) && !solution(z, q4)){
    //                                 w = q4;
    //                                 System.out.print(x+ ""+y+""+z+""+w );
                                    
    //                             }
    //                         }
    //                     }
    //                 }
    //         }
    //         }
            
    //     }
    // }

    // static boolean solution(int i, int j){
    //     if((j-i)%4==0){
    //         return false;
    //     }if(j-i==3){
    //         return false;
    //     }if(j-1==5){
    //         return false;
    //     }
    //     return true;
    // }

    // public static void displayBoard(int[][] board){
    //     for(int[] row: board){
    //         for(int column: row){
    //             System.out.print(column + "    ");
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void displayBoard(int[][] board){
    //     int n = board.length;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             System.out.print(board[i] == j ? "Q " : ". ");
    //         }
    //         System.out.println();
    //     }
    // }
}
}