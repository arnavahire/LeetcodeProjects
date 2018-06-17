import java.util.LinkedList;
import java.util.Queue;

class CernerBST {
    TreeNode root;

    class TreeNode
    {
        char character;
        TreeNode left;
        TreeNode right;

        public TreeNode(char input)
        {
            this.character=input;
        }
    }

    public TreeNode insert(TreeNode root, char key)
    {
        if(root==null)
            root=new TreeNode(key);
        else
        {
            if(key<=root.character)
            {
                root.left=insert(root.left,key);
            }
            else
            {
                root.right=insert(root.right,key);
            }
        }
        return root;
    }

    public void insertIntoBST(char input)
    {
        root=insert(root,input);
    }

    public void printBST()
    {
        if(root==null)
            System.out.println("Empty BST");
        else
        {
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty())
            {
                TreeNode poppedNode=queue.poll();
                System.out.println(poppedNode.character);
                if(poppedNode.left!=null)
                    queue.add(poppedNode.left);
                if(poppedNode.right!=null)
                    queue.add(poppedNode.right);
            }
        }
    }

    public void inorder(TreeNode root)
    {
        if(root.left!=null)
            inorder(root.left);
        System.out.println(root.character);
        if(root.right!=null)
            inorder(root.right);
    }


}

public class CernerBSTTest
{
    public static void main(String[] args)
    {
        CernerBST bst=new CernerBST();
        String str="CERNER";
        str=str.toLowerCase();
        for(int i=0;i<str.length();i++)
        {
            bst.insertIntoBST(str.charAt(i));
        }

        //bst.printBST();
        bst.inorder(bst.root);
    }
}
