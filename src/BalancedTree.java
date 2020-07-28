import java.util.*;
import java.lang.*;
import java.io.*;



class BalancedTree {
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

        int arr[]={1,2,3,4,5,6,7,8,9};

        TreeNode root = new TreeNode();
        root = sortedArrayToBST(arr);

        System.out.print("Inorder - ");
        print_inorder(root);
        System.out.println();

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



}