
    /*
    in this problems we will find out the min intermediate cost from src to dest.. 
    whichever is min, we will add src value and return
    */
    
    import java.io.*;
    import java.util.*;
    

    
    public class minCostMaze {
    
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            int maze[][] = new int[row][col];
             int dp[][] = new int[row][col];
            for(int i = 0;i<row;i++){
                for(int j =0;j<col;j++){
                    maze[i][j] = sc.nextInt();
                }
            }

           //int res =  findMinCostMaze(maze, 0, 0);
           //int res =  findMinCostMaze_memo(maze, 0, 0, dp);
           int res = findMinCostMaze_tabulation(maze, 0, 0, dp);
           System.out.println(res);
        }

        //mormal recursion

      public static int findMinCostMaze(int[][] maze, int x, int y){

          if(x == maze.length-1 && y ==maze[0].length-1){
              return maze[x][y];
          }
          
          int minCost = (int) 1e9;
          if(y+1< maze[0].length){
            minCost = Math.min(minCost, findMinCostMaze(maze, x, y+1));
          }
          if(x+1<maze.length){
              minCost = Math.min(minCost, findMinCostMaze(maze, x+1, y));
          }
          return minCost + maze[x][y];
        
      }
       //memoization
      public static int findMinCostMaze_memo(int[][] maze, int x, int y, int[][]dp ){

        if(x == maze.length-1 && y == maze[0].length-1){
            return dp[x][y] = maze[x][y];
        }

        if(dp[x][y] != 0){
            return dp[x][y];
        }


        int CostMin = (int) 1e9;

        if(y+1< maze[0].length){
         CostMin = Math.min(CostMin, findMinCostMaze_memo(maze, x, y+1, dp));
        }

        if(x+1<maze.length){
            CostMin =Math.min(CostMin, findMinCostMaze_memo(maze, x+1, y, dp));
        }


        return dp[x][y] = (CostMin+maze[x][y]);
    }

    //tabulation----

    public static int findMinCostMaze_tabulation(int[][] maze, int x, int y, int[][]dp ){
        for(x = maze.length-1;x>=0;x--){
            for(y = maze[0].length-1;y>=0;y--){
              if(x == maze.length-1 && y == maze[0].length-1){
                  //bottom right corner
                   dp[x][y] = maze[x][y];

              }else if(x == maze.length-1){
                  //last row
                  dp[x][y] = maze[x][y]+dp[x][y+1];

              }else if(y == maze[0].length-1){
               //last column
               dp[x][y] = maze[x][y] + dp[x+1][y];
              }
              else{
                dp[x][y] = maze[x][y]+Math.min(dp[x][y+1],dp[x+1][y]);
              }
            }
        }
        return dp[0][0];
    }


    }
