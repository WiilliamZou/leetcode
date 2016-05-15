public class Solution2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        int k = n - m;
        int j = m;
        while(j > 1){
            prev = prev.next;
            j--;
        }
        ListNode curr = prev.next;
        while(k > 0){
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = prev.next;
            prev.next = temp;
            k--;
        }
        if(m == 1){
            head = prev.next;
        }
        return head;
    }
}