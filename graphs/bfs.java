/*
1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path, 
     starting from the src.

input:
7    --->>length
8    ----> items
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2   --->> st pt
 Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346
*/
    
    import java.io.*;
    import java.util.*;
    
    public class bfs {
       static class Edge {
          int src;
          int nbr;
    
          Edge(int src, int nbr) {
             this.src = src;
             this.nbr = nbr;
          }
       }
       public static class BFSPair {
        int vtx;
        String psf;

        BFSPair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static void bfs_(ArrayList<Edge>[] graph, int src) {
        Queue<BFSPair> qu = new LinkedList<>();
        qu.add(new BFSPair(src, "" + src));
        boolean[] vis = new boolean[graph.length];

        while(qu.size() > 0) {
            // 1. get + remove
            BFSPair rem = qu.remove();
            // 2. mark *
            if(vis[rem.vtx] == true) {
                // already visited -> continue
                continue;
            } else {
                // unvisited -> mark it as visited
                vis[rem.vtx] = true;
            }
            // 3. work 
            System.out.println(rem.vtx + "@" + rem.psf);
            // 4. add unvisited neighbours
            for(Edge e : graph[rem.vtx]) {
                if(vis[e.nbr] == false) {
                    qu.add(new BFSPair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
       public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
          int vtces = Integer.parseInt(br.readLine());
          ArrayList<Edge>[] graph = new ArrayList[vtces];
          for (int i = 0; i < vtces; i++) {
             graph[i] = new ArrayList<>();
          }
    
          int edges = Integer.parseInt(br.readLine());
          for (int i = 0; i < edges; i++) {
             String[] parts = br.readLine().split(" ");
             int v1 = Integer.parseInt(parts[0]);
             int v2 = Integer.parseInt(parts[1]);
             graph[v1].add(new Edge(v1, v2));
             graph[v2].add(new Edge(v2, v1));
          }
    
          int src = Integer.parseInt(br.readLine());
    
          bfs_(graph, src);
       }
    }



    