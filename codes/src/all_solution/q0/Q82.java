package all_solution.q0;

import model.ListNode;

import java.text.NumberFormat;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode left = head, right = head;
        while (right != null) {
            while (right != null && right.val == left.val) {
                right = right.next;
            }
            if (left.next == right) {
                cur.next = left;
                cur = cur.next;
                left.next = null;
            }
            left = right;
        }
        return dummy.next;
    }
}
