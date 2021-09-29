
   //leetcode 542
   /*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
    */
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    
    public class Zero0neMatrix {

        static int[] xdir = {-1, 0, 1, 0};  
        static int[] ydir = {0, -1, 0, 1};
        private static class Pair01 {
            int x;
            int y;
    
            public Pair01(int x, int y) {
                this.x = x;
                this.y = y;
            }
    
        }
        public static int[][] updateMatrix(int[][] mat) {
            Queue<Pair01> qu = new LinkedList<>();
            boolean[][] vis = new boolean[mat.length][mat[0].length];
            // 1. travel and fill the queue with 0
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[0].length; j++) {
                    if(mat[i][j] == 0) {
                        qu.add(new Pair01(i, j));
                        vis[i][j] = true;
                    }
                }
            }
            // 2. Run BFS and mark level in given matrix and use a visited matrix
            int level = -1;
            while(qu.size() > 0) {
                level++;
                int size = qu.size();
                while(size-- > 0) {
                    Pair01 rem = qu.remove();
                    mat[rem.x][rem.y] = level;
                    for(int d = 0; d < 4; d++) {
                        int r = rem.x + xdir[d];
                        int c = rem.y + ydir[d];
                        if(r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && vis[r][c] == false) {
                            qu.add(new Pair01(r, c));
                            vis[r][c] = true;
                        }
                    }
                }
            }
            return mat;
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
    
        int[][] ans = updateMatrix(arr);
    
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            System.out.print(ans[i][j] + " ");
          }
          System.out.println();
        }
    
      }
    
     
    }
