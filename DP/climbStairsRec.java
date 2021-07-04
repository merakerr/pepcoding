
    //this problems states that how many times that the function get called and executed
    import java.io.*;
    import java.util.*;
import java.util.concurrent.CountDownLatch;
    
    public class climbStairsRec {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int []dp = new int[n+1];
            //int res = climbStair(n);
            int res = climbStair_memo(n, dp);
            System.out.println(res);
        }

        public static int climbStair(int n){
            if(n == 0){
                return 1;
            }
            int count = 0;

            for(int j = 1; j<=3;j++){
              if(n-j >= 0){
                  count += climbStair(n-j);
              }
            }
            return count;
        }

        //climb stair with memoization
        public static int climbStair_memo(int n, int dp[]){
           if(n == 0){
               return dp[0] = 1;
           }

           if(dp[n] != 0){
               return dp[n];
           }

           int count = 0;

           for(int j = 1;j<=3;j++){
               if(n-j>=0){
                   count += climbStair_memo(n-j, dp);
               }
           }
           return dp[n] = count;

        }

        //climbstair tabulation
        public static int climbStair_tabu(int n, int dp[]){
            /*
        1)figure out repetion --->repetetion on N
        2)make a storage of size-->N+1
        3)Assign meaning to cell-->dp[i] = path from ith src to dest.
        4)direction of traversal-->smallest prob. is at 0 
        5) prerequsite -->dp[0] = 1-->there is one path from 0-->0 , ie dnt move      
        */
           dp[0] = 1;

           for(int i = 1;i<=n;i++){
               int count = 0;
               for(int j = 1; j<=3; j++){
                   if(i-j>=0){
                       count += dp[i-j];
                   }
               }
               dp[i] = count;
           }
           return dp[n];
         }

    
    }
