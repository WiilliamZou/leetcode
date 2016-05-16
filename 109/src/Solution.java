/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBST(list, 0, list.size()-1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, start, mid-1);
        root.right = sortedListToBST(list, mid+1, end);
        return root;
    }


}