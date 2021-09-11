package all_solution.q0;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while (true) {
            int count = k;
            while (count-- > 0 && tail != null) {
                tail = tail.next;
            }
            // reach the end
            if (tail == null) break;
            ListNode nextDummy = pre.next;
            while (pre.next != tail) {
                // delete pre.next
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                // insert to tail.next
                temp.next = tail.next;
                tail.next = temp;
            }
            tail = nextDummy;
            pre = nextDummy;
        }
        return dummy.next;
    }
}
