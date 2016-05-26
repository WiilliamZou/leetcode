import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/26/16.
 */
public class Solution02 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null){
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, res, level+1);
        }
        if (root.left != null) {
            dfs(root.left, res, level+1);
        }
    }
}
