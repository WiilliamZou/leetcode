/**
 * Created by yunxiaozou on 6/4/16.
 */
public class Solution2 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);
        return sb.toString();
    }

    private void helperS(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null").append(",");
            return;
        }
        // preorder 的情况
        sb.append(node.val).append(",");

        helperS(node.left, sb);
        helperS(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals  = data.split(",");
        int[]    index = {0};
        return helperD(vals, index);
    }

    private TreeNode helperD(String[] vals, int[] index){
        if(index[0] == vals.length){
            return null;
        }

        String visiting = vals[index[0]++];
        if(visiting.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(visiting));
        node.left     = helperD(vals, index);
        node.right    = helperD(vals, index);

        return node;
    }
}
