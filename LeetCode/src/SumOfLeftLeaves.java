/*Problem Statement:
Find the sum of all left leaves in a given binary tree.
    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

public class SumOfLeftLeaves {

        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null)
                return 0;
            int answer=0;
            if(root.left != null)
            {
                if(root.left.left == null && root.left.right == null )  // add to answer only if there exists a left leaf node
                {
                    answer+=root.left.val;
                }
                else
                {
                    answer+=sumOfLeftLeaves(root.left);
                }
            }
            answer+=sumOfLeftLeaves(root.right);

            return answer;


        }

}
