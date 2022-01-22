package all_solution.q0;

import model.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head, right = head;
        while (right != null) {
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            left.next = right;
            left = right;
        }
        return head;
    }
}
