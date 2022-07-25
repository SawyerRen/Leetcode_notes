package ng2022.q100;

import model.ListNode;

public class Q143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode dummy = new ListNode();
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        ListNode head2 = dummy.next;
        while (head2 != null) {
            ListNode next = head.next;
            head.next = head2;
            head = head2;
            head2 = next;
        }
    }
}
