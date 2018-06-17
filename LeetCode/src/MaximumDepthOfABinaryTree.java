/*PROBLEM STATEMENT: Max. Depth of a binary tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

*/

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfABinaryTree {
    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        int maxDepth=0;

        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();

                if(node.left!=null)
                    queue.add(node.left);

                if(node.right!=null)
                    queue.add(node.right);
            }
            maxDepth++;              // increase the depth value after exploring the popped node
        }

        return maxDepth;

    }
}
