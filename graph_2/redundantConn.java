//leetcode 684
/*
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n,
 with one additional edge added. The added edge has two different vertices chosen
  from 1 to n, and was not an edge that already existed. The graph is represented 
  as an array edges of length n where edges[i] = [ai, bi] indicates that there is
   an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n
nodes. If there are multiple answers, return the answer that occurs last in the
 input.


Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 
*/
    import java.util.*;
    import java.io.*;
    
    public class redundantConn {
        public static int[] findRedundantConnection(int[][] edges) {
          int n = edges.length;
          int[] setleaders = new int[n + 1];
          int[] rank = new int[n + 1];

          for(int i = 0; i < n + 1; i++){
              setleaders[i] = i;
              rank[i] = 1;
          }
           
          for(int[] edge : edges){
              int x = edge[0];
              int y = edge[1];
             int val1 = find(setleaders, x);
             int val2 = find(setleaders, y);

             //if set leader are similar means cycle detected
             if(val1 == val2){
                 return edge;
             }
             //else perform union over them
             union(val1, val2, setleaders, rank);
          }
          return new int[0];
        }
      
        private static void union(int x, int y, int[] setleaders, int[] rank){
            if(rank[x] > rank[y]){
              setleaders[y] = x;
            }
            else if(rank[x] < rank[y]){
               setleaders[x] = y;
            }
            else{
             setleaders[y] = x;
             rank[x]++;
            }
        }
        private static int find(int[] parent, int f) {
            if(parent[f] == f){
                return f;
            }

            int val = find(parent, parent[f]);
            parent[f] = val;
            return val;
        }
      public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
    
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          pos[i][0] = Integer.parseInt(st[0]);
          pos[i][1] = Integer.parseInt(st[1]);
        }
    
        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
      }
    
      
    }