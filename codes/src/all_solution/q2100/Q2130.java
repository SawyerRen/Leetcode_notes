package all_solution.q2100;

import model.ListNode;

public class Q2130 {
    public int pairSum(ListNode head) {
        if (head == null) return 0;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        ListNode head2 = pre.next;
        pre.next = null;
        ListNode head1 = reverse(head);
        int res = Integer.MIN_VALUE;
        while (head1 != null) {
            res = Math.max(res, head1.val + head2.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
