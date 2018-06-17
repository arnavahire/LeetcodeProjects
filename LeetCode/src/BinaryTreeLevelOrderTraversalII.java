import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listOfLevels=new LinkedList<List<Integer>>();  //  the list that will contain the list of nodes at each level

        if(root==null)             // if root is null, return empty list
            return listOfLevels;

        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        queue.add(root);      // add root to queue

        while (!queue.isEmpty())
        {
            List<Integer> levelNodes=new LinkedList<Integer>();   // for each level we will have a list that will contain the nodes at that level
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                levelNodes.add(node.val);

                if(node.left!=null)
                    queue.add(node.left);

                if(node.right!=null)
                    queue.add(node.right);
            }

            listOfLevels.add(levelNodes);    // we add the list of nodes at a level  to our final list

        }

        Collections.reverse(listOfLevels);    // We have all the nodes at each level from top to bottom stored in 'listOfLevels', we simply do Collections.reverse to get bottom to top ordering

        return listOfLevels;
    }
}
