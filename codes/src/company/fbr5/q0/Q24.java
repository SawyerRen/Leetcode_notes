package company.fbr5.q0;

import model.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            ListNode l3 = cur.next.next.next;
            cur.next = l2;
            l2.next = l1;
            l1.next = l3;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
