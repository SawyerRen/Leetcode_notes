package all_solution.q0;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(), largeHead = new ListNode();
        ListNode small = smallHead, large = largeHead;
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
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;
    }
}
