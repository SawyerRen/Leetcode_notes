package company.fbr5.q200;

import model.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
