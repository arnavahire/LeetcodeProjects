/* PROBLEM STATEMENT: Binary Tree ZigZag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zigzagTraversalList=new LinkedList<List<Integer>>(); // the final list of levels to be returned

        if(root==null)
            return zigzagTraversalList;

        Stack<TreeNode> s1=new Stack<TreeNode>();         // s1 will store the elements levelwise from left to right
        Stack<TreeNode> s2=new Stack<TreeNode>();         // s2 will store elements levelwise from right to left

        s1.push(root);      // we push the first element onto stack s1

        while(!s1.isEmpty() || !s2.isEmpty())            // we will continue till both the stacks become empty
        {
            LinkedList<Integer> listForStack1=new LinkedList<Integer>();
            while(!s1.isEmpty())
            {
                TreeNode poppedItem=s1.pop();
                listForStack1.add(poppedItem.val);       // each time we pop the element, we put it iside the list that will conntain the nodes at that level

                if(poppedItem.left!=null)                // nodes from left to right will be pushed on stack 2, so that after popping, the right will be popped first, then the left
                    s2.push(poppedItem.left);
                if(poppedItem.right!=null)
                    s2.push(poppedItem.right);
            }

            LinkedList<Integer> listForStack2=new LinkedList<Integer>();
            while(!s2.isEmpty())
            {
                TreeNode poppedItem=s2.pop();
                listForStack2.add(poppedItem.val);

                if(poppedItem.right!=null)             // nodes from right to left will be pushed on stack 1 so that after popping, the left node will be popped first, then the right
                    s1.push(poppedItem.right);
                if(poppedItem.left!=null)
                    s1.push(poppedItem.left);
            }

            if(listForStack1.size()>0)                 // we append the lists for both stacks to our final list only if the size of those lists is greater than 0
                zigzagTraversalList.add(listForStack1);

            if(listForStack2.size()>0)
                zigzagTraversalList.add(listForStack2);
        }

        return zigzagTraversalList;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.right=new TreeNode(5);

        BinaryTreeZigZagLevelOrderTraversal btzzlot=new BinaryTreeZigZagLevelOrderTraversal();
        List<List<Integer>> result=btzzlot.zigzagLevelOrder(root);
        for(int i=0;i<result.size();i++)
        {
            for(int j=0;j<result.get(i).size();j++)
            {
                System.out.println(result.get(i).get(j));
            }
            System.out.println("*************************");
        }
    }
}
