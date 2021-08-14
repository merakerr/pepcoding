/*
                 50
               /     \
          *  25      75
           /   \     /  \
         12   37     62  87
             /  \   /  \
            30  40 74  70
          
as 74 is greater than 70 hence the right side bst is cancelled till 50,
here from 25 node the bst property is fullfilled, hence,

Node :-25
Size :- 5
25@5  => is the output

*/
    
    import java.io.*;
    import java.util.*;
    
    public class largestBSTsubtree {
      public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    
      public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }
    
      public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }
      

      //code written here ***********************************
 
      static int sz = 0;
      static Node bstNode = null;
      public static BSTPair largestBST(Node node) {
          if(node == null) return new BSTPair();
  
          BSTPair lres = largestBST(node.left);
          BSTPair rres = largestBST(node.right);
  
          boolean status = lres.max < node.data && rres.min > node.data;
  
          BSTPair mres = new BSTPair();
          mres.min = Math.min(node.data, Math.min(lres.min, rres.min));
          mres.max = Math.max(node.data, Math.max(lres.max, rres.max));
          mres.isbst = lres.isbst && rres.isbst && status;
          mres.size = lres.size + rres.size + 1;
          
          if(mres.isbst == true && mres.size > sz) {
              bstNode = node;
              sz = mres.size;
          }
  
          return mres;
      }   
  
      //BST PAIR
      public static class BSTPair {
        int min;
        int max;
        boolean isbst;
        int size;

        public BSTPair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isbst = true;
            size = 0;
        }
    }


      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        Node root = construct(arr);
        System.out.println(bstNode.data + "@" + sz);
      }
    
    }
