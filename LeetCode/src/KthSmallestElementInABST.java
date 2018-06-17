/* PROBLEM STATEMENT: Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*/

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<Integer>();
        list=inorder(root,list);                 // the inorder traversal will return us all the elements from smallest to largest in asccending order. take this output in a list
        return list.get(k-1);           // to find the kth smallest  element, return the [k-1]th element from the list, that's our answer
    }
    public List<Integer> inorder(TreeNode root,List<Integer> list)
    {
        if(root.left!=null)
            inorder(root.left,list);
        list.add(root.val);
        if(root.right!=null)
            inorder(root.right,list);
        return list;
    }
}
