package company.fbr5.again;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, tail = dummy;
        while (true) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode nextDummy = pre.next;
            while (pre.next != tail) {
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            pre = nextDummy;
            tail = nextDummy;
        }
        return dummy.next;
    }
}
