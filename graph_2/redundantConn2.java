//leetcode 685
/*
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.
Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]
*/


    
    import java.util.*;
    import java.io.*;

    public class redundantConn2 {


    private static int[] parent;
    private static int[] rank;

    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    private static boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if(lx == ly) {
            return true;
        } else {
            if(rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if(rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[ly] = lx;
                rank[lx]++;
            }
        }
        return false;
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1]; 
        Arrays.fill(indegree, -1);
        int blackList1 = -1;
        int blackList2 = -1;

        for(int i = 0; i < edges.length; i++) {
            int v = edges[i][1];

            if(indegree[v] == -1) {
                indegree[v] = i;
            } else {
                blackList1 = i;
                blackList2 = indegree[v];
                break;
            }
        }

        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // apply DSU and avoid blk1
        //edge index, and check if graqph is cyclic or not
        for(int i = 0; i < edges.length; i++) {
            if(i == blackList1) {
                continue;
            }
            int u = edges[i][0];
            int v = edges[i][1];

            boolean isCyclic = union(u, v);
            if(isCyclic == true) {
                if(blackList1 == -1) {
                    return edges[i];
                } else {
                    return edges[blackList2];
                }
            }
        }
        return edges[blackList1];
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
    
        int[] ans = findRedundantDirectedConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
      }
    
    
    
      
    
    }
