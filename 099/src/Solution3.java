import java.util.Stack;

/**
 * Created by yunxiaozou on 5/15/16.
 */
public class Solution3 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;

        TreeNode curr = root;
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() ||  curr != null){
            if(curr != null){
                //visit curr's left subtree
                stack.push(curr);
                curr = curr.left;
            }else{
                //done left subtree of curr Node
                curr = stack.pop();

                //compare curr.val with prev.val if we have one
                if(prev != null && curr.val <= prev.val){
                    //incorrect smaller node is always found as prev node
                    if(first == null) first = prev;
                    //incorrect larger node is always found as curr node
                    second = curr;
                }

                //visit curr's right subtree
                prev = curr;


                curr = curr.right;
            }
        }

        //recover swapped nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
