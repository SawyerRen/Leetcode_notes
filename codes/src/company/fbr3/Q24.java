package company.fbr3;

import model.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            cur.next = l2;
            l1.next = l2.next;
            l2.next = l1;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
