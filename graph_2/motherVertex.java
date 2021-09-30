/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other 
vertices of the Graph.
Input Format
First line contains two space separated integers,N and M. Then M lines follow,
 each line has 2 space separated integers ai and bi.
input:
4 3
1 2
2 3
3 4
Sample Output
1
*/


    import java.io.*;
    import java.util.*;
    public class motherVertex {
        private static void dfsForStack(ArrayList<ArrayList<Integer>> graph, 
        int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfsForStack(graph, nbr, vis, st);
            }
        }
        st.push(src);
    }

    private static int count = 0;
    private static void dfsForCount(ArrayList<ArrayList<Integer>> graph, 
        int src, boolean[] vis) {
        vis[src] = true;
        count++;
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                dfsForCount(graph, nbr, vis);
            }
        }
    }

    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> graph){
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < N; v++) {
            if(vis[v] == false) {
                dfsForStack(graph, v, vis, st);
            }
        }

        int top = st.peek();
        count = 0;
        vis = new boolean[N];
        dfsForCount(graph, top, vis);
        return count == N ? top + 1: -1;
    }
            public static void main(String args[]) throws Exception {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
    
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
    
            for (int i = 0; i < m; i++) {
                st = br.readLine().split(" ");
                int u = Integer.parseInt(st[0]) - 1;
                int v = Integer.parseInt(st[1]) - 1;
                graph.get(u).add(v);
            }
    
            System.out.println(findMotherVertex(n, graph));
        }
        
    }