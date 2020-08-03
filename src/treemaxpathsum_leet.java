import java.util.*;
import java.lang.*;
import java.io.*;


class treemaxpathsum_leet {
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

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans=maxPathSum1(root);          //O(n), fast recursive
        //ans=maxPathSum(root);             //Probably O(n^2), slow DFS

        System.out.println(ans);



    }

    //__________________________________________________________________________________________________________

    //METHOD - 2, Fast recursive method with O(n) time

    public static int maxx;       //global variable for storing final answer

    static int maxPathSum1(TreeNode root) {

        maxx=Integer.MIN_VALUE;
        maxPathDown(root);
        return maxx;

    }

    static int maxPathDown(TreeNode root) {   //Using to calculate maxsum when root is highest point of the path
        if(root==null)
            return 0;

        int l=Math.max(0,maxPathDown(root.left));
        int r=Math.max(0,maxPathDown(root.right));

        maxx=Math.max(maxx, root.val+l+r);  //updating final answer by taking current root
                                            // as highest point of path and the left & right sub-branches of the path

        return root.val+Math.max(l,r);      //calculating maximum sum when taking left/right sub-branch & current root
    }

//________________________________________________________________________________________________________________

    //METHOD - 1 , Using BFS & inorder traversals (Quite slow for large no. of nodes)


    static int maxPathSum(TreeNode root) {
        int n=nodesnumber(root);        //total no. of nodes in binary tree

        TreeNode[][] arr = new TreeNode[4][n];      //acts as adjacency matrix for all n nodes
        //row 0 for all nodes, row 1 for their left child, row 2 for right child, row 3 for parent node
        inorder(root, arr, null);       //making the adjacency matrix using inorder traversal

        return DFS(arr);

    }

    static int DFS(TreeNode[][] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr[0].length;
        for (int i = 0; i < n; i++) {       //selecting arr[0][i] node as source node
            boolean visited[] = new boolean[n];
            int x = DFSUtil(arr, visited, arr[0][i].val, arr[0][i].val, i);

            if (max < x)
                max = x;
        }

        return max;
    }

    static int DFSUtil(TreeNode[][] arr, boolean[] visited, int curr, int maxx, int idx) {
        // curr - value of current node, maxx - max sum till now , idx - index of current node
        visited[idx] = true;

        int i , z = maxx;
        for (int p = 1; p < 4; p++) {       //looping thru all possible 3 adjacent nodes of current nodes
            if (arr[p][idx] != null) {
                TreeNode nx = arr[p][idx];
                for (i = 0; i < arr[0].length; i++)
                    if (arr[0][i] == nx)            //i is index of this new node nx
                        break;

                if (visited[i] == false)
                    z = DFSUtil(arr, visited, curr + nx.val, Math.max(maxx, curr + nx.val), i);

                maxx = Math.max(z, maxx);
            }
        }

        return maxx;

    }

    public static int k = 0;

    static void inorder(TreeNode root, TreeNode[][] arr, TreeNode parent) {     //for creating adjacency matrix of each node
        if (root != null) {
            inorder(root.left, arr, root);
            arr[0][k] = root;                   //current node
            arr[1][k] = root.left;              //node's left child
            arr[2][k] = root.right;             //node's right child
            arr[3][k] = parent;                 //node's parent
            ++k;
            inorder(root.right, arr, root);
        }
    }

    static int nodesnumber(TreeNode root) {         //for counting no. of nodes in binary tree
        if(root!=null) {
            int l=nodesnumber(root.left);
            int r=nodesnumber(root.right);
            return l+r+1;
        }
       return 0;
    }

    //______________________________________________________________________________________________________________
}