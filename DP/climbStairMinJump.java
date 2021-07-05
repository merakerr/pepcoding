

import java.util.*;
public class climbStairMinJump {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
         
        }
        int dp[] = new int[n+1];
       // int result = climbStairminJumpRecursion(0, n, arr);
        // int res = climbStairminJump_memo(0,n,arr,dp);
        int res = climbStairminJump_tabu(0,n,arr,dp);
        System.out.println(res);
    }

    public static int climbStairminJumpRecursion(int i, int n, int[] jumps){
        if(i == n){
            return 0;
        }
        int minJump = (int) 1e9;
        

        for(int jmp = 1;jmp <= jumps[i] && jmp+i<=n;jmp++){
            minJump = Math.min(minJump, climbStairminJumpRecursion(i+jmp, n, jumps));
        }
        return minJump == 1e9 ? minJump : minJump+ 1;
        
    }

    //memoize

    public static int climbStairminJump_memo(int i, int n, int[] jumps, int[] dp){
        if(i == n){
            return dp[0] = 0;
        }
        int minJump = (int) 1e9;
        

        for(int jmp = 1;jmp <= jumps[i] && jmp+i<=n;jmp++){
            minJump = Math.min(minJump, climbStairminJump_memo(i+jmp, n, jumps, dp));
        }
        return minJump == 1e9 ? (dp[i] = minJump) : (dp[i] = minJump+ 1);
        
    }

    //tabulation

    public static int climbStairminJump_tabu(int i, int n, int[] jumps, int[] dp) {
        for (i = n; i >= 0; i--) {
            if (i == n) {
                dp[i] = 0;
                continue;
            }

            int minJumps = (int) 1e9;

            for (int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
                minJumps = Math.min(minJumps, dp[i + jump]); 
            }

            if (minJumps == 1e9) {
                dp[i] = (int) 1e9;
            } else {
                dp[i] = minJumps + 1;
            }
        }
        return dp[0];
    }

    
}
