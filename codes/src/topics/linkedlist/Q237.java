package topics.linkedlist;

import model.ListNode;

public class Q237 {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while (cur.next.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
        }
        cur.val = cur.next.val;
        cur.next = null;
    }
}
