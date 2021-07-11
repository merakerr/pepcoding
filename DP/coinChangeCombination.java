
import java.util.*;
import java.util.Scanner;
public class coinChangeCombination {
    
    public static void main(String[] args){
     
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] coins = new int[n];
      for(int i = 0;i<n;i++){
          coins[i] = sc.nextInt();
      }
      
    
      int target = sc.nextInt();
      int[] dp = new int[target+1];
      int res = coinChangeCombination_tabu1(coins, target, dp);
      System.out.println(res);

    }

  
   //tabulation
    public static int coinChangeCombination_tabu1(int[] coins, int target, int[] dp){
      dp[0] = 1;
      
      for(int i = 0;i<coins.length;i++){
          for(int j = coins[i];j < dp.length;j++){
             dp[j] = dp[j]+dp[j-coins[i]];
          }
      }

    return dp[target];
    }
}
