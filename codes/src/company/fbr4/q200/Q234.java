package company.fbr4.q200;

import model.ListNode;

public class Q234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l2 = reverse(slow);
        while (head != null && l2 != null) {
            if (head.val != l2.val) return false;
            head = head.next;
            l2 = l2.next;
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
