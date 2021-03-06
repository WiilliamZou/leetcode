import java.util.HashMap;
import java.util.Map;

/**
 * Created by yunxiaozou on 5/22/16.
 */
public class LRUCache03 {
    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int k, int v) {key = k; val = v;}
    }

    class DoublyLinkedList {
        private ListNode head = null;
        private ListNode tail = null;

        public void addFirst(ListNode node) {
            if (head == null) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                node.prev = null;
                head = node;
            }
        }

        public ListNode removeLast() {
            ListNode node = tail;
            if (tail.prev != null) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                head = null;
                tail = null;
            }
            return node;
        }

        public void promote(ListNode node) {
            if (node.prev == null) {
                return;
            } else {
                node.prev.next = node.next;
                if (node.next == null) {
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }

                head.prev = node;
                node.prev = null;
                node.next = head;
                head = node;
            }
        }
    }

    private final Map<Integer, ListNode> cachedMap = new HashMap<>();
    private final DoublyLinkedList cachedList = new DoublyLinkedList();
    private final int capacity;

    public LRUCache03(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cachedMap.containsKey(key))
            return -1;
        ListNode targetNode = cachedMap.get(key);
        cachedList.promote(targetNode);
        return targetNode.val;
    }

    public void set(int key, int value) {
        ListNode targetNode;
        if (cachedMap.containsKey(key)) {
            targetNode = cachedMap.get(key);
            targetNode.val = value;
            cachedList.promote(targetNode);
            return;
        }

        if (cachedMap.size() == capacity) {
            ListNode node = cachedList.removeLast();
            cachedMap.remove(node.key);
        }

        targetNode = new ListNode(key, value);
        cachedList.addFirst(targetNode);
        cachedMap.put(targetNode.key, targetNode);
    }

}
