import java.lang.module.FindException;
import java.util.*;
public class fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       // int res = fibonaci(n);
       int []dp = new int[n+1];
       int res = fibonaci_memo(n, dp);
        System.out.println(res);
    }

    //1 fibonaci using recursion
    public static int fibonaci(int n){
        if(n == 0 || n == 1){
            return  n;
        }
        int fibm1 = fibonaci(n-1);
        int fibm2 = fibonaci(n-2);
        int fib = fibm1+fibm2;
        return fib;
    }

    //fibonaci using memoization
    public static int fibonaci_memo(int n,int dp[]){
        if(n == 0 || n == 1){
            return dp[n]= n;
        }
      //1. if the problem is already solved then return the answer
        if(dp[n] != 0){
            return dp[n];
        }
        int fibm1 = fibonaci_memo(n-1,dp);
        int fibm2 = fibonaci_memo(n-2,dp);
        int fib = fibm1+fibm2;

        //if not solved , then solve the problem and store in the DP
        return dp[n] = fib;
    }
}
