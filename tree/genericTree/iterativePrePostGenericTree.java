
    
    import java.io.*;
    import java.util.*;
    import java.util.Stack;  
    
    public class iterativePrePostGenericTree {
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
      public static class Pair {
            Node node;
            int state;
    
            public Pair(Node node, int state) {
                this.node = node;
                this.state = state;
            }
        }
    

    //code written here *************************************************
      public static void IterativePreandPostOrder(Node node) {
            Stack<Pair> st = new Stack<>();
    
            st.push(new Pair(node, 0));
    
            ArrayList<Integer> pre = new ArrayList<>();
            ArrayList<Integer> post = new ArrayList<>();
    
            while(!st.empty()) {
                Pair p = st.peek();
                if(p.state == 0) {
                    pre.add(p.node.data);
                    p.state++;
                } else if(p.state <= p.node.children.size()) {
                    Node child = p.node.children.get(p.state - 1);
                    p.state++;
                    st.push(new Pair(child, 0));
                } else {
                    post.add(p.node.data);
                    st.pop();
                }
            }
    
            for(int val : pre) {
                System.out.print(val + " ");
            }
            System.out.println();
    
            for(int val : post) {
                System.out.print(val + " ");
            }
            System.out.println();
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
        IterativePreandPostOrder(root);
      }
    
    }
