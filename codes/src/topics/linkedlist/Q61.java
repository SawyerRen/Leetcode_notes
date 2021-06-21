package topics.linkedlist;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        int size = 0;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        if (size == 0) return head;
        // 此时cur指向最后一个节点
        int n = size - k % size;
        ListNode newTail = dummy;
        for (int i = 0; i < n; i++) {
            newTail = newTail.next;
        }
        cur.next = dummy.next;
        dummy.next = newTail.next;
        newTail.next = null;
        return dummy.next;
    }
}
