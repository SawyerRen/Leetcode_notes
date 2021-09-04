package all_solution.q100;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode small = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode large = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        small.next = dummy2.next;
        large.next = null;
        return dummy1.next;
    }
}
