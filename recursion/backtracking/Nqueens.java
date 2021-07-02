/*
conditions:-
1) only one queen is possible in one Row


*/
    
import java.io.*;
import java.util.*;
public class Nqueens {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [][]chessBoard = new boolean[n][n];

        //sending this function
        printNQueens(chessBoard, "", 0);
    }
   
     public static void printNQueens(boolean [][]chess, String asf, int row){
        if(row == chess.length){
            System.out.println(asf+".");
            return;
        }

        for(int col = 0; col<chess.length;col++){
             if(isqueenSafe(chess, row, col)==true){
                 //place the queen
                 chess[row][col] = true;
                 //recursive call
                 printNQueens(chess, asf+row+"-"+col+", ", row+1);
                 //unplace the queen
                 chess[row][col] = false;

             }
        }
    }
     
   // is queen safe function
    public static boolean isqueenSafe(boolean [][]chess, int row, int col){
        //check in col
        
         for(int i = row-1;i>=0;i--){
             if(chess[i][col] == true){
                 return false;
             }
         }
         //check in d1
         for(int i = row-1,j = col-1;i>=0 && j>=0;i--, j--){
            if(chess[i][j] ==true){
                return false;
            }
        }

        //check in d2
        for(int i = row-1,j = col+1;i>=0 && j<chess.length;i--, j++){
            if(chess[i][j] ==true){
                return false;
            }
        }
        return true;
    }
}
