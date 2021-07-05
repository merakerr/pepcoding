
    /*
    In this problem, we are given the number of jumps, 

    ie.. for -->0[2], 1[4], 2[3]----
    which means, from 0th index, we can move to 1 and 2 stairs,

    similary fron 1th index , we can move to , 2,3,4,5 stairs and so on
    
    */
    import java.io.*;
    import java.util.*;
    
    public class climbStairtWithVariableJumps {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
           

            int jumps[] = new int[n];
            for(int i = 0;i<n;i++){
                jumps[i] = sc.nextInt();
            }

            int dp[] = new int[n+1];
            //int res = climbStairVariable_rec(0,n,jumps);
            //int res = climbStairVariable_memo(0, n, jumps, dp);
            int res = climbStairVariable_tabu(0,n,jumps,dp);
            System.out.println(res);
        }
    


        //normal recursion problem
        //// i-> current stair, n-> total stair, jumps[] -> jumps allowed at ith stair
        public static int climbStairVariable_rec(int i, int n, int[] jumps){

         if(i == n){
             return 1;
         } 
         int count = 0;
         for(int jump =1; jump<=jumps[i] && jump+i<=n;jump++){
             count += climbStairVariable_rec(i+jump, n, jumps);
         }
           return count;
        }

        //memoization code
        public static int climbStairVariable_memo(int i, int n, int[] jumps, int[] dp){
               if(i == n){
                   return dp[i] = 1;
               }
            
               if(dp[i] != 0){
                   return dp[i];
               }
               int count = 0;

               for(int jump = 1;jump<=jumps[i] && jump+i<=n;jump++){
                   count += climbStairVariable_memo(i+jump, n, jumps,dp);
               }
               return dp[i] = count;
           }

           //tabulation

           public static int climbStairVariable_tabu(int i, int n, int[] jumps, int[] dp){
           for(i = n;i>=0;i--){
             if(i == n){
                 dp[i] = 1;
                 continue;
             }

             int count = 0;

             for(int jmp = 1;jmp <= jumps[i] && jmp+i <= n; jmp++){
                  count += dp[jmp+i];
             }
             dp[i] = count;
           }
           return dp[0];
        }
    }
