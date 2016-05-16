/**
 * Created by yunxiaozou on 5/16/16.
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        while(root.left!=null){
            TreeLinkNode tmp = root;
            while(tmp!=null){
                tmp.left.next = tmp.right;
                if(tmp.next!=null) tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            root = root.left;
        }
    }
}