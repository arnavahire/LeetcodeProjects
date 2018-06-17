import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode invertTreeMySolution(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        else
        {
            if(root.left!=null && root.right!=null)
            {
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=temp;
                invertTree(root.left);
                invertTree(root.right);
            }
            else if(root.left!=null && root.right==null)
            {
                root.right=root.left;
                root.left=null;
                invertTree(root.right);
            }
            else if(root.right!=null && root.left==null)
            {
                root.left=root.right;
                root.right=null;
                invertTree(root.left);
            }
            return root;
        }
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTreeusingQueue(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
