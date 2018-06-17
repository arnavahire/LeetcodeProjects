import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {




    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val==q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        return false;

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.right=new TreeNode(3);

        TreeNode t2=new TreeNode(1);
        t2.left=new TreeNode(2);
        t2.right=new TreeNode(3);

        SameTree st=new SameTree();
        boolean result=st.isSameTree(t1,t2);
        System.out.println(result);
    }

}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}