package company.facebook;

import model.ListNode;

import java.util.List;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        while (head != null && head2 != null) {
            if (head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        head.next = null;
        next.next = head;
        return newHead;
    }
}
