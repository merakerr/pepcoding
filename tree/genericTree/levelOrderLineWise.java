/*
similaar level order tree-->> but in this you have to print every level in line wise


                       1
                   2        3
              4       5    6   7 

    OUTPUT-1
          2,3
        4,5,6,7

*/
    
    import java.io.*;
    import java.util.*;
    
    public class levelOrderLineWise {
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
    
      public static int size(Node node) {
        int s = 0;
    
        for (Node child : node.children) {
          s += size(child);
        }
        s += 1;
    
        return s;
      }
    
      public static int max(Node node) {
        int m = Integer.MIN_VALUE;
    
        for (Node child : node.children) {
          int cm = max(child);
          m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);
    
        return m;
      }
    
      public static int height(Node node) {
        int h = -1;
    
        for (Node child : node.children) {
          int ch = height(child);
          h = Math.max(h, ch);
        }
        h += 1;
    
        return h;
      }
    
      public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
    
        for(Node child: node.children){
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    

      //code written here***************************
      public static void levelOrderLinewise(Node node){

        /*
        It can be done  using two Queue
        
        */
       Queue<Node> mainQ = new ArrayDeque<>();
       Queue<Node> childQ = new ArrayDeque<>();
       mainQ.add(node);

       while(mainQ.size() > 0){
           Node rem = mainQ.remove();
           System.out.print(rem.data+" ");

           //add children in the child queue
           for(Node child : rem.children){
               childQ.add(child);
           }

           //check if the all the node of parent are printed and size become
           //zero then (/n) and swap between the queue
           if(mainQ.size() == 0){
             System.out.println();
             Queue<Node> temp = mainQ;
             mainQ = childQ;
             childQ = temp;
           }
       }

       /*
       public static void levelOrderLinewise(Node node){

        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        mainQ.add(node);
        int level = 1;
        System.out.print("level"+": ");
        while(mainQ.size() > 0){
            Node rem = mainQ.remove();
            System.out.print(rem.data+" ");
            for(Node child : rem.children){
                childQ.add(child);
            }
            if(mainQ.size() == 0){
              System.out.println();
              level++;
              
              Queue<Node> temp = mainQ;
              mainQ = childQ;
              childQ = temp;
              if(mainQ.size() != 0){
                  System.out.print("level"+": ");
              }
            }
        }
       
       
       */




       
      
      }
    
      //approach 2  --->>using delimeter
      public static void levelOrderLinewise2(Node node){
        //using linked list in as queue becoz arraydeque dnt allow us to add null value
    // ------------------------
    // 1   null  2  3 null  4   5  null 
    // ------------------------
        Queue<Node> qu = new LinkedList<>();
         qu.add(node);
         qu.add(null);

         while(qu.size()>0){
          Node rem = qu.remove();
          if(rem == null){
              System.out.println();
              if(qu.size()>0){
                  qu.add(null);
              }


          }else{
              System.out.println(rem.data+" ");
              for(Node child : rem.children){
                  qu.add(child);
              }
          }
         }


      }


      //approach 3 --->>single queue using counter

      public static void levelOrderLinewise3(Node node){
       Queue<Node> qu = new LinkedList<>();
       qu.add(node);
      
        while(qu.size() > 0){
            int sz = qu.size();
            while(sz-- > 0){
                //1 get+remove
                Node rem = qu.remove();
                //2 print
                System.out.print(rem.data+" ");

                //add children
                for(Node child : rem.children){
                    qu.add(child);
                }

            }
            //after 1 line complete 
            System.out.println();
        }
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
        //levelOrderLinewise(root);
        levelOrderLinewise2(root);
      }
    
    }
