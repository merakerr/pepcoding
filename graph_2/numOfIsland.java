//leetcode 200
/*
Given an m x n 2D binary grid grid which represents a map of '1's
 (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting
 adjacent lands horizontally or vertically. You may assume all four
  edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*/

/*
Given an m x n 2D binary grid grid which represents a map of '1's
 (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting
 adjacent lands horizontally or vertically. You may assume all four
  edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*/

class numOfIsland{
       static int[] xdir = {-1, 0, 1, 0};
       static int[] ydir = {0, -1, 0, 1};
       private static void islands_dfs(char[][] graph, int x, int y) {
           graph[x][y] = '0';
           for(int d = 0; d < 4; d++) {
               int r = x + xdir[d];
               int c = y + ydir[d];
               if(r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] != '0') {
                   islands_dfs(graph, r, c);
               }
           }
       }
   
       public int numIslands(char[][] grid) {
           int islands = 0;
           for(int i = 0; i < grid.length; i++) {
               for(int j = 0; j < grid[0].length; j++) {
                   if(grid[i][j] == '1') {
                       islands_dfs(grid, i, j);
                       islands++;
                   }
               }
           }
           return islands;
       }
}