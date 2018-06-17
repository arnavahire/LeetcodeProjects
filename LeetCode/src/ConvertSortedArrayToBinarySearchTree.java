import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length==0)    // if the array is null, we return null tree
            return null;

        TreeNode root=binarySearchTreeCreation(nums,0,nums.length-1);
        return root;

    }

    public TreeNode binarySearchTreeCreation(int[] nums, int low, int high)
    {
        if(low > high)            // if the low index is greater than high index, it means the index has gone out of bounds and no element as such exists so we return null
            return null;

        int mid=(low+high)/2;     // each time, we find the middle element and assign it as the node, in case of first node, this will be our root

        TreeNode node=new TreeNode(nums[mid]);

        node.left=binarySearchTreeCreation(nums,low,mid-1);     // the left cchild will also be determined in the similar fashion except that it will be from low to mid-1
        node.right=binarySearchTreeCreation(nums,mid+1,high);    // similarly for right child low=mid+1

        return node;

    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree csatbst=new ConvertSortedArrayToBinarySearchTree();
        int[] sortedArray={-1,-3,0,5,9};
        TreeNode root=csatbst.sortedArrayToBST(sortedArray);

        Queue<TreeNode> q=new LinkedList<TreeNode>();

        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode poppedNode=q.poll();
            System.out.println(poppedNode.val);

            if(poppedNode.left!=null)
                q.add(poppedNode.left);

            if(poppedNode.right!=null)
                q.add(poppedNode.right);
        }

    }
}
