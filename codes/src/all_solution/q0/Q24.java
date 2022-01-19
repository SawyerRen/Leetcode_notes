package all_solution.q0;

import model.ListNode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            ListNode next = l2.next;
            cur.next = l2;
            l2.next = l1;
            l1.next = next;
            cur = l1;
        }
        return dummy.next;
    }
}
