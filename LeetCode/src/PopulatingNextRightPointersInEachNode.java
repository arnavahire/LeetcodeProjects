/* PROBLEM STATEMENT: Populating next right pointers in each node

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

*/

public class PopulatingNextRightPointersInEachNode {
    static class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null)
            return;

        TreeLinkNode level=root;
        while(level.left!=null)
        {
            TreeLinkNode current=level;
            while(current!=null)
            {
                current.left.next=current.right;
                if(current.next!=null)
                {
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            level=level.left;
        }

    }

    public static void main(String[] args) {
        TreeLinkNode root=new TreeLinkNode(0);
        root.left=new TreeLinkNode(1);
        root.right=new TreeLinkNode(2);
        root.left.left=new TreeLinkNode(3);
        root.right.left=new TreeLinkNode(5);
        root.left.left.left=new TreeLinkNode(9);
        root.right.right=new TreeLinkNode(6);
        root.right.right.left=new TreeLinkNode(7);
        root.right.right.right=new TreeLinkNode(8);
        PopulatingNextRightPointersInEachNode pnrpien=new PopulatingNextRightPointersInEachNode();
        pnrpien.connect(root);

    }
}
