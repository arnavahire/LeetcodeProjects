/* PROBLEM STATEMENT: Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

*/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalList=new LinkedList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(true)
        {
            if(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            else
            {
                if(stack.isEmpty())
                    break;
                root=stack.pop();
                traversalList.add(root.val);
                root=root.right;
            }
        }

        return traversalList;
    }

}
