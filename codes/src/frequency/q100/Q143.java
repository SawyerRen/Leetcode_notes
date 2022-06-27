package frequency.q100;

import model.ListNode;

public class Q143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        while (head != null && head2 != null) {
            ListNode next1 = head.next;
            head.next = head2;
            head = head2;
            head2 = next1;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
