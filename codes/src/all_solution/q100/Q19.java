package all_solution.q100;

import model.ListNode;

public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int len = 0;
//        ListNode cur = head;
//        while (cur != null) {
//            len++;
//            cur = cur.next;
//        }
//        n = len - n;
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        cur = dummy;
//        for (int i = 0; i < n; i++) {
//            cur = cur.next;
//        }
//        cur.next = cur.next.next;
//        return dummy.next;
//    }
}
