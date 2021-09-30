//leetcode 934
/*
In a given 2D binary array grid, there are two islands.  (An island is a
 4-directionally connected group of 1s not connected to any other 1s.)
Now, we may change 0s to 1s so as to connect the two islands together to 
form 1 island.
Return the smallest number of 0s that must be flipped.  (It is guaranteed 
that the answer is at least 1.)
Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1
*/
    
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    
     public class shortestBridge {
        static int[] xdir = {-1, 0, 1, 0};  
        static int[] ydir = {0, -1, 0, 1};

        private static class pairD {
               int x;
               int y;
       
               public pairD(int x, int y) {
                   this.x = x;
                   this.y = y;
               }
           }
           private static  void dfsShortestBridge(int[][] grid, int x, int y, Queue<pairD> qu) {
               grid[x][y] = -1;
               qu.add(new pairD(x, y));
               for(int d = 0; d < 4; d++) {
                   int r = x + xdir[d];
                   int c = y + ydir[d];
       
                   if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                       dfsShortestBridge(grid, r, c, qu);
                   }
               }
       
           }
       
           public static int shortestBridge(int[][] grid) {
               Queue<pairD> qu = new LinkedList<>();
               // 1. add all 1's in queue, using DFS from first one encoutered
               loop1 : for(int i = 0; i < grid.length; i++) {
                   for(int j = 0; j < grid[0].length; j++) {
                       if(grid[i][j] == 1) {
                           dfsShortestBridge(grid, i, j, qu);
                           break loop1;
                       }
                   }
               }
               // 2. apply BFS on queue and return level when another one is encounter
               int level = -1;
       
               while(qu.size() > 0) {
                   int size = qu.size();
                   level++;
                   while(size-- > 0) {
                       pairD rem = qu.remove();
                       for(int d = 0; d < 4; d++) {
                           int r = rem.x + xdir[d];
                           int c = rem.y + ydir[d];
                           if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1) {
                               if(grid[r][c] == 1) {
                                   return level;
                               }
                               grid[r][c] = -1;
                               qu.add(new pairD(r, c));
                           }
                       }
                       
                   }
               }
       
               return -1;
           }
      public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
    
        for (int i = 0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(shortestBridge(arr));
    
      }
    
      
    }
    
