package topics.linkedlist;

import model.ListNode;

public class Q92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur1 = dummy, pre1 = null;
        for (int i = 0; i < m; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }
        ListNode pre2 = pre1;
        ListNode cur2 = cur1;
        for (int i = 0; i <= n - m; i++) {
            ListNode temp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = temp;
        }
        pre1.next = pre2;
        cur1.next = cur2;
        return dummy.next;
    }
}
