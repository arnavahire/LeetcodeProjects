/* PROBLEM STATEMENT: Construct Binary Tree From Inorder and Preorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


*/

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length-1);   // use helper function which takes preorder start position, inorder start and end position as arguments
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd)
    {
        if( preStart > preorder.length-1 || inStart > inEnd)       // if inStart > inEnd or preStart > than preorder.length it means no such node exists, so return null
            return null;

        TreeNode root=new TreeNode(preorder[preStart]);        // make the first element from preorder as the root

        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++)            // find the root element in inorder array and get its index
        {
            if(inorder[i]==root.val)
            {
                inIndex=i;
                break;
            }
        }

        root.left=helper(preorder,inorder,preStart+1,inStart,inIndex-1);          // calculate root's left by setting the prestart as +1, inorder end as inIndex-1
        root.right=helper(preorder,inorder,preStart+1+inIndex-inStart,inIndex+1,inEnd);  /// similarly calculate root's right

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal cbtfpait=new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        TreeNode root=cbtfpait.buildTree(preorder,inorder);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode pollNode=queue.poll();
            System.out.println(pollNode.val);
            if(pollNode.left!=null)
                queue.add(pollNode.left);
            if(pollNode.right!=null)
                queue.add(pollNode.right);
            System.out.println("*****");
        }

    }
}
