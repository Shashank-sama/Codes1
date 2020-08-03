import java.util.*;
import java.lang.*;
import java.io.*;



class lowestcommonancestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(-34);
        root.left.right = new TreeNode(-100);
        root.right = new TreeNode(-48);
        root.right.left = new TreeNode(-101);
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(-54);
        root.right.right.left.left = new TreeNode(-71);
        root.right.right.left.right = new TreeNode(-22);
        root.right.right.left.right.right = new TreeNode(8);

        TreeNode p=new TreeNode(-71);
        TreeNode q=new TreeNode(48);


      TreeNode ans=lowestCommonAncestor(root,p,q);
      int a=ans.val;
      System.out.println(a);


    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }
}