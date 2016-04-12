/**
 * Created by yunxiaozou on 4/12/16.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public  String toString() {
        ListNode node = this;
        StringBuffer buffer = new StringBuffer();
        while (node != null) {
            buffer.append(node.val);
            if (node.next != null)
                buffer.append("->");
            node = node.next;
        }
        return buffer.toString();
    }
}
