package topics.linkedlist;

import model.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, cur = head;
        while (cur != null) {
            while (cur != null && pre.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
        }
        return head;
    }
}
