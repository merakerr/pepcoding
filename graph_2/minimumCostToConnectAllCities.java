//leetcode 1584
/*
You are given an array points representing integer coordinates of some 
points on a 2D-plane, where points[i] = [xi, yi].
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan 
distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute
 value of val.
Return the minimum cost to make all points connected. All points
 are connected if there is exactly one simple path between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.

*/
    
import java.io.*;
import java.util.*;

public class minimumCostToConnectAllCities {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static int minCost( ArrayList<ArrayList<Edge>> graph, int size){
    int ans = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean[] vis = new boolean[size];

    pq.add(new Edge(0, 0));

    while(pq.size() > 0){
        Edge rem = pq.remove();

        if(vis[rem.v] == true){
            continue;
        }

        vis[rem.v] = true;
        ans += rem.wt;

        ArrayList<Edge> nbrs = graph.get(rem.v);
        for(Edge nbr : nbrs){
            if(vis[nbr.v] == false){
                pq.add(nbr);
            }
        }
    }
      return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
   int res = minCost(graph, vtces);
   System.out.println(res);
  }

}