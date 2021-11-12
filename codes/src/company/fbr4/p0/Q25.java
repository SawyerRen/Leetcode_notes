package company.fbr4.p0;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, tail = dummy;
        while (true) {
            int count = k;
            while (tail != null && count-- > 0) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode nextDummy = pre.next;
            while (pre.next != tail) {
                ListNode n1 = pre.next;
                pre.next = pre.next.next;
                n1.next = tail.next;
                tail.next = n1;
            }
            pre = nextDummy;
            tail = nextDummy;
        }
        return dummy.next;
    }
}
