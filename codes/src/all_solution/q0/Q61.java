package all_solution.q0;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        int length = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = length - k % length;
        ListNode cur = dummy;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        tail.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
