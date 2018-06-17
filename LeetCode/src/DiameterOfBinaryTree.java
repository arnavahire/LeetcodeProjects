/** PROBLEM STATEMENT: Diameter of Binary Tree

 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.

 **/

public class DiameterOfBinaryTree {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diamBT(root);
        return max;
    }
    public int diamBT(TreeNode node)
    {

        if(node==null)
            return 0;
        int left=diamBT(node.left);
        int right=diamBT(node.right);
        max=Math.max(max,left+right);  // we want to return the sum of max. edges on left as well as right subtree and we store this result in max variable
        return Math.max(left,right)+1;  // sam logic as that of max. depth of a binary tree
    }

    public static void main(String[] args) {

    }
}
