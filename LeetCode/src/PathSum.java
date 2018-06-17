public class PathSum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)             // if root is null then return false for any sum value
        {
            return false;
        }
        else
        {
            int addition=sum-root.val;      // subtract the given root value from the sum and if the root has any child, send this subtracted value to it
            boolean result=false, result1=false, result2=false;
            if(root.left==null && root.right==null)      // if the node is leaf node then if the final value is 0, it means we have obtained the exact sum value
            {
                if(addition==0)
                {
                    return true;   // return true for the sum value that is found out
                }
                else
                {
                    return false;
                }
            }
            else if(root.left!=null && root.right==null)  // if root has only left child then check if this path gives us the required sum
            {
                result=hasPathSum(root.left,addition);
                return result;
            }
            else if(root.left==null && root.right!=null)  // vice versa for right
            {
                result=hasPathSum(root.right,addition);
                return result;
            }
            else                                        // if root has both children then check if any of these children is returning true, because it means we have obtained the required sum
            {
                result1=hasPathSum(root.left,addition);
                result2=hasPathSum(root.right,addition);
                if(result1==true||result2==true)     // if any child returns true, return true
                {
                    return true;
                }
                else
                {
                    return false;        // if none of the child returns true, return false
                }
            }
        }
    }
}
