
    
    import java.io.*;
    import java.util.*;
    
    public class goldmines {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            int mines[][] = new int[row][col];
            for(int i = 0;i<row;i++){
                for(int j =0;j<col;j++){
                    mines[i][j] = sc.nextInt();
                }
            }
           // int res = goldmines_rec(mines);
           //int res =  goldmines_memo(mines);
           int[][] dp = new int[row][col];
           int res = goldmines_tabu(mines, 0, 0, dp);
            System.out.println(res);
        }
    
      //goldmines helper using recursion
       public static int goldmines_helper(int[][] mines, int x, int y){
             if(y == mines[0].length-1){
                 return  mines[x][y];
             }
        int cost = 0;
        //top right
        if(x-1>=0){      //(x-1>=0 && y+1 <mines[0].length
        cost = Math.max(cost, goldmines_helper(mines, x-1,y+1));
        }
        //right-->>y+1<mines[0].length
        cost = Math.max(cost, goldmines_helper(mines, x,y+1));

        //bottom right
        if(x+1<mines.length){  //x+1<mines.length && mines[0].length
            cost = Math.max(cost, goldmines_helper(mines, x+1,y+1));
        }
        return  cost+mines[x][y];
       }
       



       //goldmines helper memo

       public static int goldmine_helper_memo(int[][] mines, int x, int y, Integer[][] dp){

          if(y == mines[0].length-1){
              return dp[x][y] = mines[x][y];
          }

          if(dp[x][y] != null){
              return dp[x][y];
          }

          int cost = 0;
         //top right
          if(x-1 >= 0){
              cost = Math.max(cost, goldmine_helper_memo(mines, x-1, y+1, dp));
          }
         // right
           cost = Math.max(cost, goldmine_helper_memo(mines, x, y+1, dp));

           //bottom right
           if(x+1<mines.length){
             cost = Math.max(cost, goldmine_helper_memo(mines, x+1, y+1, dp));
           }

           return dp[x][y] = cost+mines[x][y];


       }

       ////
       //gold mines using recursion
        public static int goldmines_rec(int[][] mines){
                int profit = 0;
                for(int x = 0;x<mines.length;x++){
                    profit = Math.max(profit, goldmines_helper(mines, x, 0));
                }


            return profit;
        }




        //goldmines using memoization

        public static int goldmines_memo(int[][] mines){

            int profit = 0;
            Integer[][] dp = new Integer[mines.length][mines[0].length];

            for(int x = 0; x< mines.length;x++){
                profit = Math.max(profit, goldmine_helper_memo(mines, x, 0, dp));
            }
            return profit;
        }

        //golmines using tabulation

        public static int goldmines_tabu(int[][] mines,int x, int y, int[][] dp){
            int res = 0;
            for(y = mines[0].length-1;y>=0;y--){
                for(x = 0;x<mines.length;x++){
                    if(y == mines[0].length-1){
                     dp[x][y] = mines[x][y];
                    }else if(x == 0){
                       dp[x][y] = Math.max(dp[x][y+1],dp[x+1][y+1])+mines[x][y];
                    }else if(x == mines.length-1){
                        dp[x][y] = Math.max(dp[x][y+1],dp[x-1][y+1])+mines[x][y];
                    }else{
                        dp[x][y] = Math.max(dp[x-1][y+1],Math.max(dp[x][y+1],dp[x+1][y+1])+mines[x][y]);
                    }
                    res =Math.max(res, dp[x][y]);
                }
            }

            return res;
        }



        
    }
