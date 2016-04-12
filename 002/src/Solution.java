/**
 * Created by yunxiaozou on 4/12/16.
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode p = newList;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int number = 0;
            if (l1 != null) {
                number += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                number += l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                number += carry;
                carry = 0;
            }
            if (number > 9) {
                number -= 10;
                carry = 1;
            }
            p.next = new ListNode(number);
            p = p.next;
        }
        return newList.next;
    }
}