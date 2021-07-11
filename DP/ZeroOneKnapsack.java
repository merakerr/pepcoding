
import java.util.*;
public class ZeroOneKnapsack {
   public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] values = new int[n];
    int[] wts = new int[n];
 
    for(int i = 0;i<n;i++){
        values[i] = sc.nextInt();
    }
    for(int i = 0;i<n;i++){
        wts[i] = sc.nextInt();
    }

    int cap = sc.nextInt();

    int[][] dp = new int[cap+1][cap+1];
    //int res = knapsack01_rec(wts, values, n-1, cap);
    int res = knapsack01_memo(wts, values, n-1, cap, dp);
    System.out.println(res);
   } 

   //0-1 knapsack recursion

   public static int knapsack01_rec(int[] wts, int[] vals, int indx, int cap) {
    if(indx == -1) {
        return 0;
    }

    int v1 = 0;
    // yes call
    if(cap - wts[indx] >= 0) {
        v1 = knapsack01_rec(wts, vals, indx - 1, cap - wts[indx]) + vals[indx];
    }
    // no call
    int v2 = knapsack01_rec(wts, vals, indx - 1, cap);
    return Math.max(v1, v2);
}

//0-1 memo

public static int knapsack01_memo(int[] wts, int[] vals, int indx, int cap, int[][] dp) {
    if(indx == -1) {
        return dp[indx+1][cap] = 0;
    }

    int v1 = 0;
    // yes call
    if(cap - wts[indx] >= 0) {
        v1 = knapsack01_rec(wts, vals, indx - 1, cap - wts[indx]) + vals[indx];
    }
    // no call
    int v2 = knapsack01_rec(wts, vals, indx - 1, cap);
    return dp[indx+1][cap] =  Math.max(v1, v2);
}

}
