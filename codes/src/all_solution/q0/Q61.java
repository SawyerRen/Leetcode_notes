package all_solution.q0;

import model.ListNode;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        int length = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = length - k % length;
        ListNode cur = dummy;
        while (k-- > 0) {
            cur = cur.next;
        }
        tail.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
