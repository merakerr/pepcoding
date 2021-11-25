//leetcode 105
/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PreOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
*/
import java.util.*;

 public class constructBinaryTreePreOrderInOrder {

    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
//code written here 
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder.length == 0){
           return null;
       }

       return constructPreIn(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    private static TreeNode constructPreIn(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }

        int index = inStart;
        while(in[index] != pre[preStart]){
            index++;
        }
        int EleCount = index - inStart;
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = constructPreIn(pre, in, preStart + 1, preStart + EleCount, inStart, index - 1);
        root.right = constructPreIn(pre, in, preStart + EleCount + 1, preEnd, index + 1, inEnd);
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}