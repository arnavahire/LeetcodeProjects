/*PROBLEM STATEMENT: SYMMETRIC TREE

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /********** RECURSIVE SOLUTION *****************/

    public boolean isSymmetric(TreeNode root) {
        boolean symmetric= isMirror(root,root);
        return symmetric;
    }

    public boolean isMirror(TreeNode t1,TreeNode t2)
    {
        if(t1 == null && t2 == null)    // if both the nodes are null, return true
            return true;

        if(t1 == null || t2 == null)     // if one of the nodes is null and other is not, then its not a mirrored value, return false
            return false;

        if((t1.val == t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left))  // if both the nodes have same value and whose left subtree matches the right subtree, then return true
            return true;

        return false;
    }

    /************ ITERATIVE SOLUTION ***************/

    public boolean isSymmetricIterative(TreeNode root)
    {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();  // perform level order traversal and add the same root twice to the queue
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty())
        {
            TreeNode t1=queue.poll();        // remove the first 2 nodes in the queue
            TreeNode t2=queue.poll();

            if(t1==null && t2==null)         // check if they both are null if yes then continue to remove next 2 nodes
                continue;

            if(t1==null || t2==null)         // if one of the nodes is null and the other is not, then the nodes are not symmetric, hence return false
                return false;

            if(t1.val!=t2.val)               // similarly, if both the nodes have different values, return false
                return false;

            if(t1.val==t2.val)              // if values match, add the t1's left node followed by t2's right node so that the next time these two elements get popped, they can be compared to check the symmetry
            {
                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);     // similarly we add t1's right node followed by t2's left node to check the symmetry
                queue.add(t2.left);
            }
        }
        return true;
    }
}
