


import java.util.*;
public class countBinaryString {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
    
        int[][] dp = new int[n+1][2];

       //int res = countBinaryString_rec(n, 1, "");
      // int res = countBinaryString_memo(n, 1, dp);
      int res =   countBinaryString_optimise(n);
       System.out.println(res);
      
    }

    //count string recursion

    public static int countBinaryString_rec (int n, int lastItem, String asf){
        if(n == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        //prevents the repeatation of consecutive 0
        if(lastItem == 1){
            count = count+countBinaryString_rec(n-1, 0, asf+"0");
        }
        count = count+ countBinaryString_rec(n-1,1,  asf+"1");

        return count;
    }


    //count binary string memo
    public static int countBinaryString_memo(int n, int lastItem, int[][] dp){
        if(n == 0){
            return dp[n][lastItem] = 1;
        }

        if(dp[n][lastItem] != 0){
            return dp[n][lastItem];
        }
         int count = 0;
        if(lastItem == 1){
            count += countBinaryString_memo(n-1, 0,dp);
        }
        count += countBinaryString_memo(n-1, 1,dp);
        return dp[n][lastItem] = count;
    }

    //optimized
    public static int countBinaryString_optimise(int n) {
        int zero = 1;
        int one = 1;

        for(int i = 2; i <= n; i++) {
            int n_zero = one;
            int n_one = one + zero;

            zero = n_zero;
            one = n_one;
        }
        return one + zero;
    }
}
