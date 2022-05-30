package all_solution.q0;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (right == null) break;
                right = right.next;
            }
            if (right == null) break;
            ListNode tempLeft = left.next;
            while (left.next != right) {
                ListNode temp = left.next;
                left.next = left.next.next;
                temp.next = right.next;
                right.next = temp;
            }
            left = tempLeft;
            right = tempLeft;
        }
        return dummy.next;
    }
}
