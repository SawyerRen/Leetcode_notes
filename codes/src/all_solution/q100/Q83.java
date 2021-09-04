package all_solution.q100;

import model.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode left = head, right = head;
        while (right != null) {
            while (right != null && right.val == left.val) {
                right = right.next;
            }
            left.next = right;
            left = right;
        }
        return head;
    }
}
