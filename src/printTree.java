import java.util.*;
import java.lang.*;
import java.io.*;



class printTree {
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

        int arr[]={1,2,3,4,5,6,7,8,9};               //ascending order sorted array for input in BST

        TreeNode root = new TreeNode();
        root = sortedArrayToBST(arr);

        System.out.print("Inorder - ");
        print_inorder(root);                //Inorder print
        System.out.println();
        System.out.print("Preorder - ");
        print_preorder(root);               //Preorder print
        System.out.println();
        System.out.print("Postorder - ");
        print_postorder(root);               //PostOrder print


        int h=depth(root);

        System.out.println();
        System.out.print("LevelOrder - ");

        for(int i=0;i<=h;i++)
        {
            print_lvl(root, i);              //LevelOrder print by going one lvl at a time
        }


    }

    static TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;

        if (n > 0) {
            int x = nums[n / 2];
            TreeNode root = new TreeNode(x);

            int larr[] = new int[n / 2];
            int rarr[] = new int[n - n / 2 - 1];

            System.arraycopy(nums, 0, larr, 0, n / 2);
            System.arraycopy(nums, n / 2 + 1, rarr, 0, n - n / 2 - 1);

            root.left = sortedArrayToBST(larr);
            root.right = sortedArrayToBST(rarr);

            return root;
        }

        return null;

    }

    static void print_inorder(TreeNode root) {

        if (root != null) {
            print_inorder(root.left);
            System.out.print(root.val + ", ");
            print_inorder(root.right);
        }
    }

    static void print_preorder(TreeNode root){

        if (root != null) {
            System.out.print(root.val + ", ");
            print_preorder(root.left);
            print_preorder(root.right);
        }
    }


    static void print_postorder(TreeNode root) {

        if(root!=null) {
            print_postorder(root.left);
            print_postorder(root.right);
            System.out.print(root.val+", ");
        }

    }


    static void print_lvl(TreeNode root, int h) {

        if(h==0){
            System.out.print(root.val+", ");
        }

        if(root.left!=null)
            print_lvl(root.left, h-1);
        if(root.right!=null)
            print_lvl(root.right, h-1);

    }

    static  int depth(TreeNode root) {

        if(root.left==null&&root.right==null)
            return 0;

        int h1=0,h2=0;

        if(root.left!=null)
            h1=depth(root.left);
        if(root.right!=null)
            h2=depth(root.right);

        int h=Math.max(h1,h2)+1;

        return  h;
    }

}