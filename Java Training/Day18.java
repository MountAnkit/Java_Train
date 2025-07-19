import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Stack;

public class Day18
{
    static class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int v)
        {
            value =v;
        }
    }

    static class BinaryTree
    {
        public void zigZag(TreeNode root)
        {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);

            while(!stack1.isEmpty() || !stack2.isEmpty())
            {
                while(!stack1.isEmpty())
                {
                    TreeNode current = stack1.pop();
                    System.out.print(current.value+" ");

                    if(current.left != null)
                    {
                        stack2.push(current.left);
                    }
                    if(current.right != null)
                    {
                        stack2.push(current.right);
                    }
                }
                System.out.println();
                while(!stack2.isEmpty())
                {
                    TreeNode current = stack2.pop();
                    System.out.print(current.value+" ");

                    if(current.right != null)
                    {
                        stack1.push(current.right);
                    }
                    if(current.left != null)
                    {
                        stack1.push(current.left);
                    }
                }
                System.out.println();
            }
        }
        public static boolean validBST(TreeNode root)
        {
            if(root.left==null||root.right==null) return true;
            if(root.left.value >root.value || root.right.value<root.value )
            {
                return false;
            }
            boolean left = validBST(root.left);
            boolean right = validBST(root.right);
            return left&&right;

        }

        public static int findHeight(TreeNode root)
        {
            if(root == null)
            {
                return -1;
            }
            int lh = findHeight(root.left);
            int rh = findHeight(root.right);
            return Math.max(lh,rh)+1;
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTree tree = new BinaryTree();
        tree.zigZag(root);
        System.out.println("Height : "+tree.findHeight(root));

        BinaryTree tree1 = new BinaryTree();
        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(40);
        root1.right = new TreeNode(60);
        root1.left.left = new TreeNode(39);
        root1.left.right = new TreeNode(42);
        root1.left.right.right = new TreeNode(41);

        System.out.println(tree1.validBST(root1));

    }

}
