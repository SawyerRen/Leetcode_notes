package all_solution.q200;

import model.ListNode;

public class Q148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);
        return merge(n1, n2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 != null) cur.next = n1;
        else if (n2 != null) cur.next = n2;
        return dummy.next;
    }
}
