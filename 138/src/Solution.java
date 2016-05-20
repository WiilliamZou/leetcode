import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    Map<RandomListNode, RandomListNode> map;
    public RandomListNode copyRandomList(RandomListNode head) {
        map = new HashMap<>();
        return copyRandomListNode(head);
    }

    private RandomListNode copyRandomListNode(RandomListNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        RandomListNode copyNode = new RandomListNode(node.label);
        map.put(node, copyNode);
        copyNode.random = copyRandomListNode(node.random);
        copyNode.next = copyRandomListNode(node.next);
        return copyNode;
    }
}