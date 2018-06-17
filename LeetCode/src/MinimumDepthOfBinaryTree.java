/*PROBLEM STATEMENT: Min. Depth of a binary tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root)
    {
        Queue<TreeNode> q=new LinkedList<TreeNode>();  // LinkedList offers queue implementation

        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        q.add(root);
        int depth=1;

        while(!q.isEmpty())
        {
            int size=q.size();           // for each level we perform this loop and after end of each loop we increment the depth

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.peek();
                q.poll();

                if(node.left==null && node.right==null)     // if the node is a leaf node then we directly return the depth
                    return depth;

                if(node.left!=null)      // else we add the left and right children to the queue
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepthRecursive(TreeNode root)
    {
        if(root==null)   // if root doesn't exist
            return 0;

        if(root.left==null && root.right==null)   // if only root exists
            return 1;

        if(root.left==null)                       // if no left child exists
            return minDepthRecursive(root.right)+1;

        if(root.right==null)                       // if no right child exists
            return minDepthRecursive(root.left)+1;

        return Math.min(minDepthRecursive(root.left),minDepthRecursive(root.right))+1;  // if both left and right child exist
    }
}
