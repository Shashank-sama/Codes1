import java.util.*;
import java.lang.*;
import java.io.*;



class BSTcheck
{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main (String[] args)throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(23);


        boolean ans = isValidBST(root);
        System.out.println("Given tree is binary tree - "+ans);



    }


    static boolean isValidBST(TreeNode root) {
        return isBSTmm(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isBSTmm(TreeNode root, long min, long max) {

        if(root==null)
            return true;

        if(root.val<=min || root.val>=max)
            return false;

        return isBSTmm(root.left, min, root.val ) && isBSTmm(root.right, root.val, max);
    }

    /*
//________________________________________________________________________________________________
    //METHOD - 2 (My own)



    static boolean isValidBST(TreeNode root) {

        if(root==null)
            return true;

        return inorder(root);
    }

    static TreeNode prev;

     static boolean inorder(TreeNode root){

        if(root==null)
            return true;

        boolean x=inorder(root.left);

        if(x&&prev==null)
        {
            prev=root;
            if(inorder(root.right))
                return true;
            else
                return false;
        }
        else if(x&&prev!=null)
        {
            if(prev.val<root.val)
            {
                prev=root;
                if(inorder(root.right))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else if(!x)
            return false;

        return true;

    }

 //___________________________________________________________________________________________________

    //METHOD - 3


    public boolean isValidBST(TreeNode root) {
         return isBST(root);
    }

    static TreeNode prev;

    boolean isBST(TreeNode root) {

        if (root!=null)
        {
            if (!isBST(root.left))
                return false;

            if (prev!=null&&root.val<=prev.val)
                return false;

            prev=root;

            return isBST(root.right);
        }
    return true;
    }


    */



}

