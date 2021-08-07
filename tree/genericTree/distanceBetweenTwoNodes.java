/*
distane between two nodes can happens in two ways
1) Edge wise
2) node wise
              1
           /    \
        2         3
      /  \      /  \
    4    5     6    7 
                \
                8

distance between  4 and 8 -->>5 (edge wise) 
distance between  4 and 8--->>6 (node wise) 



steps:

1) find nodetoroot for D1
2) find nodetoroot for D2
3)traverse from end till it matches the value ie i==j
4)index+1 from i and index+j return




*/
    
    import java.io.*;
    import java.util.*;
    public class distanceBetweenTwoNodes {
        private static class Node {
            int data;
            ArrayList<Node> children = new ArrayList<>();
          }
        
          public static void display(Node node) {
            String str = node.data + " -> ";
            for (Node child : node.children) {
              str += child.data + ", ";
            }
            str += ".";
            System.out.println(str);
        
            for (Node child : node.children) {
              display(child);
            }
          }
        
          public static Node construct(int[] arr) {
            Node root = null;
        
            Stack<Node> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
              if (arr[i] == -1) {
                st.pop();
              } else {
                Node t = new Node();
                t.data = arr[i];
        
                if (st.size() > 0) {
                  st.peek().children.add(t);
                } else {
                  root = t;
                }
        
                st.push(t);
              }
            }
        
            return root;
          }
          public static ArrayList<Integer> nodeToRootPath(Node node, int data){
            if(node.data == data){
                ArrayList<Integer> bres = new ArrayList<>();
                bres.add(node.data);
                return bres;
            }
            for(Node child : node.children){
                ArrayList<Integer> rres = nodeToRootPath(child, data);
                if(rres.size() > 0){  //means items is found 
                    rres.add(node.data);
                    return rres;
                }
            }
    
            return new ArrayList<>();
         }
    
        //code written here ***************************************************** best sol
        public static int distanceBetweenNodes(Node node, int d1, int d2){
            ArrayList<Integer> dis1 = nodeToRootPath(node, d1);
            ArrayList<Integer> dis2 = nodeToRootPath(node, d2);

            int i = dis1.size()-1;
            int j = dis2.size()-1;
           
            while(i>=0 && j>=0 && dis1.get(i)==dis2.get(j)){
                i--;
                j--;
            }

            return i+j+2; //i+1  and j+1

        }
    
         
          public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
              arr[i] = Integer.parseInt(values[i]);
            }
        
            int d1 = Integer.parseInt(br.readLine());
            int d2 = Integer.parseInt(br.readLine());
            Node root = construct(arr);
              int dist = distanceBetweenNodes(root, d1,d2);
            System.out.println(dist);
            // display(root);
          }
        
        }
    