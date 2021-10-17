package company.facebook;

import model.ListNode;

public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, odd = head;
        ListNode evenHead = head.next, even = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
