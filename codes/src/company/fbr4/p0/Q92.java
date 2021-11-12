package company.fbr4.p0;

import model.ListNode;

public class Q92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, tail = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }
        while (pre.next != tail) {
            ListNode n1 = pre.next;
            pre.next = pre.next.next;
            n1.next = tail.next;
            tail.next = n1;
        }
        return dummy.next;
    }
}
