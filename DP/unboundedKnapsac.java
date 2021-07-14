import java.util.*;
public class unboundedKnapsac {
  public static void main(String[] args){
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

    int[][] dp = new int[n+1][cap+1];
   // int res = unboundedKnapsac_rec(wts, values, n-1, cap);
   int res = unboundedKnapsac_memo(wts, values, n-1, cap, dp);
    System.out.println(res);
  }  


  //unbounded recursion
  public static int unboundedKnapsac_rec(int[] wts, int[] values, int index, int cap){
      if(cap == 0 || index == -1){
          return 0;
      }

      int v1 = 0;

      //yes call
      if(cap-wts[index]>=0){
        v1 = unboundedKnapsac_rec(wts, values, index, cap-wts[index]) + values[index];
      }

      //no call
      int v2 = unboundedKnapsac_rec(wts, values, index-1, cap);

       return Math.max(v1, v2);
  }

  //unbounded memo
  public static int unboundedKnapsac_memo(int[] wts, int[] values, int index, int cap, int[][] dp){
    if(cap == 0 || index == -1){
        return dp[index + 1][cap] = 0;
    }

    if(dp[index+1][cap] != 0){
        return dp[index+1][cap];
    }
    int v1 = 0;

    //yes call
    if(cap-wts[index]>=0){
      v1 = unboundedKnapsac_memo(wts, values, index, cap-wts[index],dp) + values[index];
    }

    //no call
    int v2 = unboundedKnapsac_memo(wts, values, index-1, cap,dp);

     return dp[index+1][cap] = Math.max(v1, v2);
  }
}
