//leetcode 829
    
/*
Given an integer n, return the number of ways you can write n as
 the sum of consecutive positive integers.

Example 1:
Input: n = 5
Output: 2
Explanation: 5 = 2 + 3

Example 2:
Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4

*/

    import java.util.*;

    public class consecutiveNumberSum {
    
      // ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
      public static int consecutiveNumbersSum(int n) {
        int count = 0;
        for(int k = 1; k * (k - 1) < 2 * n; k++) {
            int numerator = n - (k* (k - 1) / 2);
            if(numerator % k == 0) {
                count++;
            }
                
        }       
        return count;
      }
    
      // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int res = consecutiveNumbersSum(num);
        System.out.println(res);
      }
    }
