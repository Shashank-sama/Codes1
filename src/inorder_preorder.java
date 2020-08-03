import java.util.*;
import java.lang.*;
import java.io.*;



class inorder_preorder {
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

        int pre[] = {1, 2};
        int in[] = {2, 1};
        TreeNode ans = new TreeNode();
        ans = buildTree(pre, in);

    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        if (n == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);

        int curr = 0;
        for (int i = 0; i < n; i++)
            if (inorder[i] == preorder[0])
                curr = i;

        builder( preorder, inorder, 0, curr, n - 1, root);

        return root;
    }
public static int start=0;

    static void builder( int[] pre, int[] in, int low, int curr, int high, TreeNode root) {

        if (!(low <= curr && curr <= high))
            return;

        if (low == curr && curr == high)
            return;

        int x = -100, i;

        if (start < pre.length - 1)
            x = pre[++start];

        for (int j = low; j < curr; j++) {
            if (in[j] == x) {
                root.left = new TreeNode(x);
                builder( pre, in, low, j, curr - 1, root.left);
                if (start < pre.length - 1)
                    x = pre[++start];
            }
        }


        for (int j = curr + 1; j <= high; j++) {
            if (in[j] == x) {
                root.right = new TreeNode(x);
                builder( pre, in, curr + 1, j, high, root.right);
                if (start < pre.length - 1)
                    x = pre[++start];
            }
        }

        return;

    }
}