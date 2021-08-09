
    
    import java.io.*;
    import java.util.*;
    
    public class nodeWithMaxSum {
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
    //code written here ********************************
           /*
                1(15)   -->>sum = 15   -->> nodedata = 1
               / \
          (11)2   3
            /  \
           4    5

        

           
           */

    static int nodeData = 0;
    static int maxSum = Integer.MIN_VALUE;
    public static int treeSum(Node node){
        int sum = 0;
        for(Node child : node.children){  // ex 2,3
            sum += treeSum(child);
        }

        sum += node.data;                //eg 1 (      2+3 = 5   -->>5+1)
        if(sum > maxSum){
            nodeData = node.data;
            maxSum = sum;
        }
        return sum;
    }



      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        Node root = construct(arr);
        treeSum(root);
        System.out.println(nodeData+"@"+maxSum);
      }
    
    }
