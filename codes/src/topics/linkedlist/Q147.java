package topics.linkedlist;

import model.ListNode;

public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null) {
            ListNode next = head.next;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
            cur = dummy;
        }
        return dummy.next;
    }
}
