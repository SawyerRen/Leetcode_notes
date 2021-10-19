package company.facebook;

import model.ListNode;
import org.w3c.dom.NodeList;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode node = swapPairs(next.next);
        head.next = node;
        next.next = head;
        return next;
    }
}
