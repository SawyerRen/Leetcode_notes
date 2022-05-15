package all_solution.q1700;

import model.ListNode;

import java.util.ArrayList;

public class Q1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode swap1 = head, swap2 = head;
        ListNode left = head, right = head;
        for (int i = 0; i < k - 1; i++) {
            right = right.next;
        }
        swap1 = right;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        swap2 = left;
        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
        return head;
    }
}
