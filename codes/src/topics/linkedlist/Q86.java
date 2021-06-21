package topics.linkedlist;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(), dummy2 = new ListNode();
        ListNode cur1 = dummy1, cur2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = dummy2.next;
        cur2.next = null;
        return dummy1.next;
    }
}
