import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ConvertBSTToGreaterTree {

    int sum=0;         // required in improved version's code

    /****************************** BRUTE FORCE ***************************************/

    public TreeNode convertBST(TreeNode root) {

        if(root==null)
            return root;

        HashSet<Integer> set=new HashSet<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty())         // we traverse the tree level wise and insert node values in hashset one by one
        {
            TreeNode node=queue.poll();
            if(!set.contains(node.val))
                set.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            int newValue=0;
            for(Integer element:set)            // we take a new variable and append all the node values that are greater than that node's value
            {
                if(element>node.val)
                    newValue+=element;
            }
            node.val+=newValue;                 // we apppend the original node's value and thus we get the new node value
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        return root;
    }

    /*********************** Improved Version **********************************/

    public TreeNode convertToBSTImproved(TreeNode root)
    {
        convertNode(root);
        return root;
    }

    public void convertNode(TreeNode node)
    {
        if(node==null)
            return;

        convertNode(node.right);
        node.val+=sum;
        sum=node.val;
        convertNode(node.left);

    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        ConvertBSTToGreaterTree cbsttogt=new ConvertBSTToGreaterTree();
        TreeNode fin=cbsttogt.convertBST(root);

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
    }

}
