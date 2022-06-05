package all_solution.q0;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode dummy = new ListNode(0, head);
        int len = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = len - k % len;
        ListNode newTail = dummy;
        for (int i = 0; i < k; i++) {
            newTail = newTail.next;
        }
        tail.next = dummy.next;
        dummy.next = newTail.next;
        newTail.next = null;
        return dummy.next;
    }
}
