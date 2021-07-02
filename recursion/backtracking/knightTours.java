import java.util.*;
public class knightTours {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int r = sc.nextInt();
     int c = sc.nextInt();
     int [][]chess = new int[n][n];
     printNightTour(chess, r, c, 1);
    }
    public static void printNightTour(int[][] chess, int r, int c, int stepno){
           //base case
           if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c] != 0){
               return;
           }
           if(stepno == chess.length*chess.length){
            chess[r][c] = stepno;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
           }


        chess[r][c] = stepno;
        printNightTour(chess, r-2, c+1, stepno+1);
        printNightTour(chess, r-1, c+2, stepno+1);
        printNightTour(chess, r+1, c+2, stepno+1);
        printNightTour(chess, r+2, c+1, stepno+1);
        printNightTour(chess, r+2, c-1, stepno+1);
        printNightTour(chess, r+1, c-2, stepno+1);
        printNightTour(chess, r-1, c-2, stepno+1);
        printNightTour(chess, r-2, c-1, stepno+1);
        chess[r][c] = 0;
    }
    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
