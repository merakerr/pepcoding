//graph creation------++++++++++++++++=

import java.util.*;

public class graph{

public static class Edge{
   int v1;
   int v2;
   int wt;

   //constructor
   public Edge(int v1, int v2, int wt){
      this.v1 = v1;
      this.v2 = v2;
      this.wt = wt;
   }

}
   //add edge
   public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt){
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
   }

   public static void display(ArrayList<Edge>[] graph){
      /*
     [0] -->( 0-1@10, 0-3@40 )
     [1] -->( 1-0@10, 1-2@10 ) etc
     */

     for(int v = 0; v < graph.length; v++){
        System.out.print("["+v+"] ->");
        for(int n = 0; n < graph[v].size(); n++){
           Edge e = graph[v].get(n);
           System.out.print("["+e.v1+"-"+e.v2+"@"+e.wt+"], ");
        }
        System.out.println();
     }
   }

   public static void fun(){
     int n = 7;    //number of vertices
     ArrayList<Edge>[] graph = new ArrayList[n];
     for(int i = 0; i < n; i++){
        graph[i] = new ArrayList<>();
     }

   //   addEdge(graph, 0, 1, 10);
   //   addEdge(graph, 0, 3, 40);
   //   addEdge(graph, 1, 2, 10);
   //   addEdge(graph, 2, 3, 10);
   //   addEdge(graph, 3, 4, 2);
   //   addEdge(graph, 4, 5, 3);
   //   addEdge(graph, 4, 6, 8);
   //   addEdge(graph, 5, 6, 3);

   int[][] data = {
      {0, 1, 10},       //v1 v2 wt
      {0, 3, 40},
      { 1, 2, 10},
      {2, 3, 10},
      {3, 4, 2},
      {4, 5, 3},
      {4, 6, 8},
     { 5, 6, 3}
   };
   
  for(int []arr : data){
     addEdge(graph, arr[0],arr[1], arr[2]);
  }
     //display
     display(graph);

     /*
     [0] -->( 0-1@10, 0-3@40 )
     [1] -->( 1-0@10, 1-2@10 ) etc
     */
   }

 


   public static void main(String[] args) {
      fun();
   }
}