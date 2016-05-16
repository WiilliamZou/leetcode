import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution02 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        traverse(result, 0, root);
        return result;
    }

    private void traverse(List<List<Integer>> result, int level, TreeNode curr) {
        if (curr == null) return ;
        if (result.size() <= level) result.add(new ArrayList<>());
        if (level % 2 == 0) result.get(level).add(curr.val);
        else result.get(level).add(0, curr.val);
        traverse(result, level+1, curr.left);
        traverse(result, level+1, curr.right);

    }
}
