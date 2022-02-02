package all_solution.q100;

import model.ListNode;

public class Q143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        merge(head, head2);
    }

    private void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
