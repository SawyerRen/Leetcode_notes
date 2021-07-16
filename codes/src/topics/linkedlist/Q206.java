package topics.linkedlist;

import model.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(head.next);
        head.next = null;
        next.next = head;
        return newHead;
    }
}
