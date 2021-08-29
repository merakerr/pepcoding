  /*
  find out from source to destination the path is there or not.

  ie src = 0, dest = 6
    find out is there any path going from 0 to 6.
    if yes return true else false
  
  */
    
  import java.io.*;
  import java.util.*;
  
  public class hasPath {
     static class Edge {
        int v1;
        int v2;
        int wt;
  
        Edge(int src, int nbr, int wt){
           this.v1 = src;
           this.v2 = nbr;
           this.wt = wt;
        }
     }

     public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
      if(src == dest){
         return true;
      }
       vis[src] = true;
       for(Edge e : graph[src]){
          int nbr = e.v2;     //nbr == neighbour
 
          //if neighbour is unvisited, then only move to the neighbour
          if(vis[nbr] == false){
             boolean res = hasPath(graph, nbr, dest, vis);
             if(res == true){
                return true;
             }
          }
          
       }
 
       return false;
    }
 
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
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
        System.out.println(hasPath(graph,src, dest,vis ));
     
        // write your code here
      }
  
  }
