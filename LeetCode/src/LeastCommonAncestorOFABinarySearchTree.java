public class LeastCommonAncestorOFABinarySearchTree {


    /* Driver program to test lca() */
    public static void main(String args[])
    {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = tree.lowestCommonAncestor(tree.root, tree.root.left.right.left, tree.root.left.right.right);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

        n1 = 14;
        n2 = 8;
        t = tree.lowestCommonAncestor(tree.root, tree.root.left.right.right, tree.root.left);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

        n1 = 10;
        n2 = 22;
        t = tree.lowestCommonAncestor(tree.root, tree.root.left.right.left, tree.root.right);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

    }

}
/*
class TreeNode
{
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class BinaryTree
{
    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}