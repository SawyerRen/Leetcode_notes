package all_solution.q200;

import model.ListNode;

public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (head != null) {
            ListNode next = head.next;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            cur = dummy;
            head = next;
        }
        return dummy.next;
    }
}
