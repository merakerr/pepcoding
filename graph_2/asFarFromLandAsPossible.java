//leetcode 1162
/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
Example 1:
Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
*/
    
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    
    public class asFarFromLandAsPossible {
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
    public static  int maxDistance(int[][] grid) {
        // iterate on grid and add all 1's in queue and mark it as well
        Queue<pairD> qu = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    qu.add(new pairD(i, j));
                    grid[i][j] = -1;
                }
            }
        }

        // run BFS 
        if(qu.size() == 0 || qu.size() == grid.length * grid[0].length)
            return -1;
        
        int level = -1;
        while(qu.size() > 0) {
            level++;
            int size = qu.size();
            while(size-- > 0) {
                pairD rem = qu.remove();
                for(int d = 0; d < 4; d++) {
                    int r = rem.x + xdir[d];
                    int c = rem.y + ydir[d];

                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1) {
                        qu.add(new pairD(r, c));
                        grid[r][c] = -1;
                    }
                }
            }
        }
        return level;
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
    
        System.out.println(maxDistance(arr));
    
      }
    
      
    }
    
