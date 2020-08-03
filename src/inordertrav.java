import java.util.*;
import java.lang.*;
import java.io.*;



class inordertrav
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

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);



        //MorrisTraversal(root);                          //inorder traversal without recursion or stack

        List<Integer> l=new ArrayList<>();
        l=inorderTraversal_usingstack(root);              //iterative inorder traversal using stack
        System.out.println(l);

        //inorderTraversal1(root);                        //recursive inorder traversal
        //System.out.println(lt);


    }


    //___________________________________________________________________________________________________________
//METHOD - 1 (Recursive)



    public static List<Integer> lt=new ArrayList<>();         //global list for storing inordered list of nodes

    static void inorderTraversal1(TreeNode root){             //inorder traversal using recursion
        if(root!=null) {
            inorderTraversal1(root.left);
            lt.add(root.val);
            inorderTraversal1(root.right);
        }
    }
//_______________________________________________________________________________________________________________


    //METHOD - 2 (Iterative)


    static List<Integer> inorderTraversal_usingstack(TreeNode root) {    //Iterative method for inorder traversal using stack

        List<Integer> l=new ArrayList<>();
        if(root==null)
            return l;

        Stack<TreeNode> st=new Stack<>();
        TreeNode temp=root;

        while(temp!=null||st.size()!=0) {
            while(temp!=null) {
                st.push(temp);
                temp=temp.left;
            }

            temp=st.pop();
            l.add(temp.val);

            temp=temp.right;

        }

        return l;
    }

    //__________________________________________________________________________________________________________


    //METHOD - 3

    static void MorrisTraversal(TreeNode root)    //Inorder traversal without using recursion or stack
    {
        TreeNode current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    //___________________________________________________________________________________________________________


}

