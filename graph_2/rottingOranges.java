
//leetcode 994
/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

*/
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    
    public class rottingOranges {
    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};
    public class OPair {
        int r;
        int c;
        int t;

        public OPair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<OPair> qu = new LinkedList<>();

        // 1. travelling on grid, adding rotted orange in a queue, and counting oranges
        int orange = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2)
                    qu.add(new OPair(i, j, 0));

                if(grid[i][j] == 1 || grid[i][j] == 2)
                    orange++;
            }
        }

        // 2. apply BFS and find remaining orange count and time as well
        int time = 0;
        
        while(qu.size() > 0) {
            OPair rem = qu.remove();
            if(grid[rem.r][rem.c] == -2) {
                continue;
            }
            grid[rem.r][rem.c] = -2;

            orange--;
            time = rem.t;

            for(int d = 0; d < 4; d++) {
                int x = rem.r + xdir[d];
                int y = rem.c + ydir[d];

                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    qu.add(new OPair(x, y, rem.t + 1));
                }
            }
        }
        return orange == 0 ? time : -1;
    }
      public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(orangesRotting(arr));
    
      }
    
      
    }