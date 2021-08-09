import java.io.*;
import java.util.*;

public class diameterOfTree {
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
  public static int height(Node root) {
        int ht = -1; // on the basis of edge

        for(Node child : root.children) {
            ht = Math.max(ht, height(child));
        }

        return ht + 1;
    }
public static int diameter1(Node node) {
        int mh = -1; // max height;
        int smh = -1; // second max height

        // finding height from child
        for(Node child : node.children) {
            int ht = height(child);
            if(ht >= mh) {
                smh = mh;
                mh = ht;
            } else if(ht > smh) {
                smh = ht;
            }
        }

        int dfc = 0; // diameter from child
        for(Node child : node.children) {
            dfc = Math.max(diameter1(child), dfc);
        }
        return Math.max(dfc, mh + smh + 2);
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
    int k = diameter1(root);
    System.out.println(k);
  }

}