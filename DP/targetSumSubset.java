

import java.util.*;
public class targetSumSubset {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Boolean[][] dp = new Boolean[n+1][target+1];
        //boolean res = targetSumSubset_rec(arr,0,  target);
        //boolean res = targetSumSubset_memo(arr, 0, target, dp);
        boolean res = targetSumSubset_tabulation1(arr, target);
        System.out.println(res);
    }

    //target sum using recursion 
    public static boolean targetSumSubset_rec(int[] arr, int index, int target){
    
        if(target == 0){
            return true;
        }
        if(index == arr.length){
            return false;
        }

        boolean res = false;
        //yes call
        if(target - arr[index] >= 0){
          res = targetSumSubset_rec(arr, index+1, target-arr[index]);
        }

        //no call--->>|| (if true then dont go to make it further true)
        res = res || targetSumSubset_rec(arr, index+1, target);
        return res;
    }


    //target sum using memiization

    public static boolean targetSumSubset_memo(int[] arr, int indx, int target, Boolean[][] dp) {
        if(target == 0) return dp[indx][target] = true; 
        if(indx == arr.length) {
            return dp[indx][target] = false;
        }

        if(dp[indx][target] != null) {
            return dp[indx][target];
        }

        boolean res = false;
        // yes call
        if(target - arr[indx] >= 0) {
            res = targetSumSubset_rec(arr, indx + 1, target - arr[indx]);
        }
        // no call
        res = res || targetSumSubset_rec(arr, indx + 1, target);
        return dp[indx][target] = res;
    }

    //target sum using tabulation 

    public static boolean targetSumSubset_tabulation1(int[] arr, int target){
   
      boolean[][] dp = new boolean[arr.length+1][target+1];
      for(int index = 0;index<dp.length; index++){
         for(int targ = 0; targ<dp[0].length;targ++){

             //if 0, 0 case then return true
             if(index == 0 && target == 0){ //or simply tar == 0
                dp[index][targ]= true;
             }
             else if(index == 0){
                 dp[index][targ] =false;
             }else if(targ == 0){ //first row 0-->means all true value in row 0
                 dp[index][targ] = true;
             }else{
                 if(dp[index-1][targ] == true){
                   // dp[index][targ] = dp[index-1][targ];
                 dp[index][targ] = true;
                 }
                 //else batting
                 else{
                     int val = arr[index-1];
                     if(targ >= val ){
                         if(dp[index-1][targ-val] == true){
                          dp[index][targ] = true;
                         }
                     }
                 }
            
             }
         }
      }
       return dp[dp.length-1][dp[0].length-1];
    }

}
