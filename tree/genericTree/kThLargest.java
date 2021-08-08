/*
2,4,6,7,8,9,12,35,34

k = 2 
34

second largest element

*/
    
    import java.io.*;
    import java.util.*;
    
    public class kThLargest {
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
    
      
      static int ceil;
      static int floor;
      public static void ceilAndFloor(Node node, int data) {
        if(node.data > data){
          if(node.data < ceil){
            ceil = node.data;
          }
        }
    
        if(node.data < data){
          if(node.data > floor){
            floor = node.data;
          }
        }
    
        for (Node child : node.children) {
          ceilAndFloor(child, data);
        }
      }
    /*
    In this problems we have data = max value ---infinity
    ceilandfloor(data) gives floor of max element--

    now again we need to reset the floor value to min_value 
    because node.data<data--->floor    else this wont execute

    we need k times execution to move the floor value exact to the Kth largest
    */
      public static int kthLargest(Node node, int k){
        int data = Integer.MAX_VALUE;
        for(int i = 0; i< k; i++){ 
            floor = Integer.MIN_VALUE;
            ceilAndFloor(node, data);
            data = floor;
        }
        return data;
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        int k = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        int kthLargest = kthLargest(root, k);
        System.out.println(kthLargest);
      }
    
    }
