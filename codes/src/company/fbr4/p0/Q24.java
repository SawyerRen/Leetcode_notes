package company.fbr4.p0;

import model.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;
            ListNode next = n2.next;
            cur.next = n2;
            n2.next = n1;
            n1.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
