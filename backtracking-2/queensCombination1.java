/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
*/
    
    import java.io.*;
    import java.util.*;
    
    public class queesCombination1 {
    
        public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
            
            if(col == tq){  //if col reaches to the end
                row++;
                col = 0;
                asf += '\n';
            }
            
            if(row == tq){  //if row reaches to the end
                if(qpsf == tq){
                    System.out.println(asf);
                   
                }
                 return;
            }
            queensCombinations(qpsf + 1, tq, row, col + 1, asf+"q"); //yes call
            queensCombinations(qpsf, tq, row, col + 1, asf+"-"); //no call
            
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            
            queensCombinations(0, n, 0, 0, "");
        }
    }
