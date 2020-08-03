import java.util.*;
import java.lang.*;
import java.io.*;


class Treelvlorder
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


    public static void main (String[] args)throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);

        List<List<Integer>> ll = levelOrder(root);

        System.out.println(ll);

        printLevelOrder(root);

    }

    static void printLevelOrder(TreeNode root) {                //printing lvlorder using queue in O(n) time
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");

            /*Enqueue left child */
            if (temp.left != null) {
                queue.add(temp.left);
            }

            /*Enqueue right child */
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {     //creating list of all level nodes in levelorder in O(n^2)

        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();

        int h=depth(root);

        for(int i=0;i<=h;i++) {
            l = onelvl(root, i);

            ll.add(new ArrayList(l));
        }

        return ll;
    }

    static  List<Integer> onelvl(TreeNode root, int h) {      //returning list of all nodes of a single level

        List<Integer> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();

        if(h==0) {
            l.add(root.val);
            return l;
        }

        if(root.left!=null)
            l=onelvl(root.left, h-1);
        if(root.right!=null)
            l1=onelvl(root.right, h-1);


            l.addAll(l1);


        return l;
    }

    static  int depth(TreeNode root) {               //returning depth of tree where root depth=0

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
