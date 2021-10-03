/*
A vertex in an undirected graph is an articluation point iff removing
 it disconnects the graph. You have to find the number of articulation
  point in the given graph

Input:
5 5
1 2
1 3
3 2
3 4
5 4
Sample Output
2
*/
    
    import java.util.*;
    public class articulationPoint {
        static int time = 0;
    
        private static void dfsArticulation(ArrayList<ArrayList<Integer>> graph, 
        int src, boolean[] vis, int[] parent, int[] disc, int[] low, boolean[] arti) {
            disc[src] = low[src] = time;
            time++;
            vis[src] = true;
            int count = 0; // count for finding original source status
            for(int nbr : graph.get(src)) {
                if(vis[nbr] == true && parent[src] != nbr) {
                    // visited but not parent
                    low[src] = Math.min(low[src], disc[nbr]);
                } else if(vis[nbr] == false) {
                    // unvisited nbr
                    parent[nbr] = src;
                    dfsArticulation(graph, nbr, vis, parent, disc, low, arti);
                    low[src] = Math.min(low[src], low[nbr]);
                    count++; // increment in count if we are making call to nbr
                    if(parent[src] == -1) {
                        // starting source              
                        if(count > 1) {
                            arti[src] = true;
                        }
                    } else {
                        if(disc[src] <= low[nbr]) {
                            arti[src] = true;
                        }
                    }
                }
            }
        }
    
    
        private static int articulationPoint(ArrayList<ArrayList<Integer>> graph) {
            int count = 0;
            int n = graph.size();
            int[] parent = new int[n];
            int[] disc = new int[n];
            int[] low = new int[n];
            boolean[] vis = new boolean[n];
            boolean[] arti = new boolean[n];
            parent[0] = -1; // parent of starting point is -1
            time = 0;
            dfsArticulation(graph,  0, vis, parent, disc, low, arti); 
            for(int i = 0; i < arti.length; i++) {
                if(arti[i] == true) {
                    count++;
                }
            }
            return count;
        }
    
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                int v1 = scn.nextInt() - 1;
                int v2 = scn.nextInt() - 1;
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            int count = articulationPoint(graph);
            System.out.println(count);
        }
    }
