import com.sun.source.tree.Tree;

public class Interview {

    //TODO: completer
    public static TreeNode solution (TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        int resultTreeVal = Math.min(t1.val, t2.val);
        TreeNode resultTree = new TreeNode(resultTreeVal);
        resultTree.left = solution(t1.left, t2.left);
        resultTree.right = solution(t1.right, t2.right);
        return resultTree;
    }
}


