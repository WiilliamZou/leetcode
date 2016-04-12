/**
 * Created by yunxiaozou on 4/12/16.
 */
public class ListHelper {
    public static ListNode constructList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int num : array) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    public static ListNode constructList(String list) {
        String[] tokens = list.split("->");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i].trim());
        }
        return constructList(array);
    }

    public static boolean compareLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }


}
