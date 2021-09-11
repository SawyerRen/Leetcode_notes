package all_solution.q0;

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
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            temp.next = tail.next;
            tail.next = temp;
        }
        return dummy.next;
    }
}
