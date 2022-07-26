package ng2022.q0;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (k % len == 0) return head;
        k = len - k % len;
        cur = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode head1 = cur;
        pre.next = null;
        while (cur.next != null) cur = cur.next;
        cur.next = head;
        return head1;
    }
}
