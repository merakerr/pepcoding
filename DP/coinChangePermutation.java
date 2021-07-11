/**
 * number of ways target can be achieved using these coins>>
 * coins->2,3,5,6 target = 7
 * num of comination to pay 7 ruppes using infinite coin of coin array-->
 */
import java.util.*;
public class coinChangePermutation {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
    }

    int target = sc.nextInt();

    int[] dp = new int[target+1];

   // int res = coinchange_perm_rec(arr,target);
   //int res = coinchange_perm_memo(arr, target, dp);
   int res = coinchange_perm_tabu1(arr, target, dp);
    System.out.println(res);

  }  

  public static int coinchange_perm_rec(int[] coins, int target){
   if(target == 0){
       return 1;
   }
   int count = 0;

   for(int coin: coins){
       if(target>=coin){
           count += coinchange_perm_rec(coins, target-coin);
       }
   }
    return count;
  }

  //coin change perm memo

  public static int coinchange_perm_memo(int[] coins, int target, int[] dp){
   
    if(target == 0){
        return dp[target] = 1;
    }

    if(dp[target] != 0){
        return dp[target];
    }
    int count = 0;
 
    for(int coin: coins){
        if(target>=coin){
            count += coinchange_perm_memo(coins, target-coin, dp);
        }
    }
     return dp[target] = count;
  }


  //coinchange tabu1
  public static int coinchange_perm_tabu1(int[] coins, int target, int[] dp){
      dp[0] = 1;

      for(int amt = 1; amt<=target;amt++){
          for(int coin:coins){
              if(coin<=amt){
                  //for target 2,   2-2,2-3,2-5,2-6-->> only 2-2 is possi.
                  int ramt = amt-coin; //2-2 = 0
                  dp[amt] += dp[ramt]; //dp[1]+dp[0]--->0+1 = 1

                  //similarly dp[8] = dp[8]+dp[6]+dp[5]+dp[3]+dp[2];-->>0+3+3+1+1-->8
              }
          }
      }
      return dp[target];
    
  }

}

/*
 **********************************************************************************
 1  0   0   0      0      0      0       0   0   0   0
 0  1   2   3      4      5      6       7   8   9   10
 .   . .2  .3    .22    .32    .222    .322
                        .23    .33     .232
                         .5    .6      .52
                                       .223

----------------------------------------------------------------------
for target ==8
coins = [,2,3,5,6]

8-2 = 6-->>   .222 2, .33 2, .6 2 --->>3 perm.
8-3 = 5-->>  .32 3, .23 3, .5 3---->3 perm.
8-5 = 3-->   .3 5------------------>1 perm.
8-6= 2-->    .2 6----------------->1 perm

total = 3+3+1+1 = 8


 */
