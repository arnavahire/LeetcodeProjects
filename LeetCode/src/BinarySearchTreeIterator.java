/* PROBLEM STATEMENT: Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* LOGIC: In order to design an iterator for BST, we will use the logic of iterative inorder traversal of tree which uses stack */

import java.util.Stack;
public class BinarySearchTreeIterator {
    Stack<TreeNode> s;

    public BinarySearchTreeIterator(TreeNode root) {      // in the constructor, we will initialize our stack and will traverse all the way to the leftmost part of the tree and push the nodes in the stack
        s=new Stack<>();
        TreeNode current=root;
        while(current!=null)
        {
            s.push(current);
            current=current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {                               // if the stack is not empty, it means there exists a smallest number
        if (!s.isEmpty())
            return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        if(!s.isEmpty())                   // if stack is not empty, pop the element and check if it has a right child, if yes, push it onto the stack and travel to left again
        {
            TreeNode removedNode=s.pop();
            TreeNode current=removedNode.right;
            while(current!=null)
            {
                s.push(current);
                current=current.left;
            }
            return removedNode.val;    // return the popped value
        }
        return -1;
    }



/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
