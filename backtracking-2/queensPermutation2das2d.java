/*
 *
 * Question
 * --------
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.

*/
    
    import java.io.*;
    import java.util.*;
    
    public class queensPermutation2das2d {
    
        public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(col == tq){
            row++;
            col = 0;
            asf += "\n";
        }
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            
            return;
        }
            //multiple choices-->>yes call
            for(int i = 0; i < queens.length; i++){
                if(queens[i] == false){
                    queens[i] = true;
                    queensPermutations(qpsf + 1, tq , row, col + 1, asf + "q" + (i+1)+"\t", queens);
                    queens[i] = false;
                }
            }
            
            queensPermutations(qpsf, tq, row, col+1, asf + "-\t", queens); //no call
            
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            boolean[] queens = new boolean[n];
    
            queensPermutations(0, n, 0, 0, "", queens);
        }
    }
