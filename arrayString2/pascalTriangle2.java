
//119. Pascal's Triangle II

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Input: rowIndex = 3
Output: [1,3,3,1]

Input: rowIndex = 0
Output: [1]
*/
    import java.util.*;
    public class pascalTriangle2 {
    
      // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
      public static ArrayList<Integer> pascalRow(int n) {
        ArrayList<Integer> res = new ArrayList<>();

        long val = 1;
        for(int row = 0; row <= n; row++){
            res.add((int)val);
            val = val * (n-row) / (row+1);
            
        }
        return res;
      }
    
      // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        ArrayList<Integer> res = pascalRow(n);
        for (int val : res) {
          System.out.print(val + " ");
        }
        System.out.println();
      }
    }
