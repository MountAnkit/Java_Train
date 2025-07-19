import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int v)
    {
        value =v;
    }
}

class BinaryTree
{
    public void inOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+"->");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.value+"->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+"->");
    }

    public TreeNode insertBST(TreeNode root,int value)
    {
        if(root==null)
        {
            return new TreeNode(value);
        }
        if(value<root.value)
        {
            root.left = insertBST(root.left,value);
        }
        else
        {
            root.right = insertBST(root.right,value);
        }
        return root;
    }

    public TreeNode deleteBST(TreeNode root,int value)
    {
        if(root==null)
        {
            return null;
        }
        if(value<root.value)
        {
            root.left = deleteBST(root.left,value);
        }
        else if(value>root.value)
        {
            root.right = deleteBST(root.right,value);
        }
        else
        {
            if(root.left == null&&root.right==null)
            {
                return null;
            }
            if(root.left==null)
            {
                return root.right;
            }
            if(root.right==null)
            {
                return root.left;
            }
            TreeNode successor = findMin(root.right);
            root.value = successor.value;
            root.right = deleteBST(root.right,successor.value);
        }
        return root;
    }
    public void levelOrder(TreeNode root)
    {
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            for(int i = 0;i<levelSize;i++)
            {
                TreeNode current = queue.poll();
                System.out.print(current.value+" ");

                if(current.left!=null) queue.add(current.left);
                if(current.right !=null) queue.add(current.right);

            }
            System.out.println();
        }
    }

    public void zigZagOrder(TreeNode root)
    {
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            for(int i = 0;i<levelSize;i++)
            {
                TreeNode current = queue.poll();
                System.out.print(current.value+" ");
                if(i%2!=0)
                {
                    if(current.left!=null) queue.add(current.left);
                    if(current.right !=null) queue.add(current.right);
                }
                else
                {
                    if(current.right !=null) queue.add(current.right);
                    if(current.left!=null) queue.add(current.left);
                }
            }
        }
    }
    public static TreeNode findMin(TreeNode root)
    {
        while(root.left!=null)
        {
            return root.left;
        }
        return root;
    }

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

    public int findHeight(TreeNode root)
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
public class Day16
{
    public static void main(String[] args)
    {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        BinaryTree tree = new BinaryTree();
//        System.out.print("InOrder Traversal - ");
//        tree.inOrder(root);
//        System.out.println();
//
//        System.out.print("preOrder Traversal - ");
//        tree.preOrder(root);
//        System.out.println();
//
//        System.out.print("postOrder Traversal - ");
//        tree.postOrder(root);
//        System.out.println();

        BinaryTree tree = new BinaryTree();
        //TreeNode root = null;
//
//        int[] values = {50,30,70,20,40,60,80};
//        for(int v:values)
//        {
//            root = tree.insertBST(root,v);
//        }
//        tree.preOrder(root);
//        System.out.println();
//
//        tree.deleteBST(root,50);
//        tree.preOrder(root);
//        System.out.println();
//        tree.levelOrder(root);
//        System.out.println();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        tree.zigZag(root);
        System.out.println(tree.findHeight(root));

    }
}
