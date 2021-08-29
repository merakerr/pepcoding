/*

given inputs
7 --->>vertices
8 --->>edges
0 1 10   --->>v1 v2 wt
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0     ------>> src
6     ------>> dest

*/
    
    import java.io.*;
    import java.util.*;
    
    public class printAllPath {
       static class Edge {
          int src;
          int nbr;
          int wt;
    
          Edge(int src, int nbr, int wt) {
             this.src = src;
             this.nbr = nbr;
             this.wt = wt;
          }
       }


       //code written here **************************

       public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf, int wsf){
       if(src == dest){
           psf += src;
           System.out.println(psf);
           return;
       }

       vis[src] = true;
       for(Edge e : graph[src]){
           int nbr = e.nbr;
           //if neighbour is not visited, then move toward it
            if(vis[nbr] == false){
                printAllPaths(graph, nbr, dest, vis, psf+src+"", wsf);
            }
       }
       vis[src] = false;
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
             int wt = Integer.parseInt(parts[2]);
             graph[v1].add(new Edge(v1, v2, wt));
             graph[v2].add(new Edge(v2, v1, wt));
          }
    
          int src = Integer.parseInt(br.readLine());
          int dest = Integer.parseInt(br.readLine());
          boolean[] vis = new boolean[dest+1];
          printAllPaths(graph, src, dest, vis, "", 0);
       }
    
    
    }
