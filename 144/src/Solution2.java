import java.util.ArrayList;
import java.util.List;

// recursive
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null){
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}

