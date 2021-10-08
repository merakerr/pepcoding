/*
Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is
 only sea in the matrix. The list pair has k operator and each operator has two 
 integer A[i].x, A[i].y means that you can change the grid mat[A[i].x][A[i].y] 
 from sea to island. Return how many island are there in the matrix after each
  operator.You need to return an array of size K.

  Input:
3 3 4
0 0
0 1
1 2
2 1
Sample Output
[1, 1, 2, 3]
*/

import java.util.*;
import java.io.*;

public class numberOfIsland2{

  static int[] xdir = {-1, 0 , 1, 0};
  static int[] ydir = {0, -1, 0, 1};
   static class Point {
        int x;
        int y;
        
        Point() { x = 0; y = 0; }
        
        Point(int a, int b) { 
            x = a; y = b;
        }
    }

    public static int find(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static void union(int lx, int ly, int[] rank, int[] parent) {
        if(rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if(rank[lx] < rank[ly]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx]++;
        }
    }
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        if(operators == null) {
            return new ArrayList<>();
        }
        int[] parent = new int[n * m];
        Arrays.fill(parent, -1);
        int[] rank = new int[n * m];

        List<Integer> res = new ArrayList<>();
        int count = 0;

        for(Point p : operators) {
            int row = p.x;
            int col = p.y;

            int boxNo = row * m + col;
            if(parent[boxNo] != -1) {
                res.add(count);
                continue;
            }
            parent[boxNo] = boxNo;
            rank[boxNo] = 1;
            count++;

            for(int d = 0; d < 4; d++) {
                int r = row + xdir[d];
                int c = col + ydir[d];

                if(r < 0 || r >= n || c < 0 || c >= m || parent[r * m + c] == -1)
                    continue;
                
                int bNo = r * m + c;
                // find set leader
                int lx = find(parent, bNo);
                int ly = find(parent, boxNo);

                // union them
                if(lx != ly) {
                    union(lx, ly, rank, parent);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);
    
    int[][] pos = new int[q][2];
    Point[] arr =  new Point[q];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
      arr[i] = new Point( pos[i][0],  pos[i][1]);
    }
 
  
    System.out.println(numIslands2(m, n, arr));
  }

  
}