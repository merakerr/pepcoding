//leetcode 1020
/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally)
 land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

*/
public class numberOfEnclaves {
    class Solution {
        static int[] xdir = {-1, 0, 1, 0};
         static int[] ydir = {0, -1, 0, 1};
       private static void numEnclave_dfs(int[][] graph, int x, int y) {
          graph[x][y] = 0;
          for(int d = 0; d < 4; d++) {
              int r = x + xdir[d];
              int c = y + ydir[d];
              if(r >= 0 && r < graph.length && c >= 0 
                  && c < graph[0].length && graph[r][c] != 0) {
                  numEnclave_dfs(graph, r, c);
              }
          }
      }
  
      public int numEnclaves(int[][] grid) {
          // for 0th row --
          for(int c = 0; c < grid[0].length; c++) {
              if(grid[0][c] == 1) {
                  numEnclave_dfs(grid, 0, c);
              }
          }
          // for last row ---
          for(int c = 0; c < grid[0].length; c++) {
              if(grid[grid.length - 1][c] == 1) {
                  numEnclave_dfs(grid, grid.length - 1, c);
              }
          }
          // for 0th col --
          for(int r = 0; r < grid.length; r++) {
              if(grid[r][0] == 1) {
                  numEnclave_dfs(grid, r, 0);
              }
          }
          // for last col --
          for(int r = 0; r < grid.length; r++) {
              if(grid[r][grid[0].length - 1] == 1) {
                  numEnclave_dfs(grid, r, grid[0].length - 1);
              }
          }
          // count remaining one ---
          int one = 0;
          for(int r = 0; r < grid.length; r++) {
              for(int c = 0; c < grid[0].length; c++) {
                  if(grid[r][c] == 1) one++;
              }
          }
          return one;
      }
  
  }  
}
