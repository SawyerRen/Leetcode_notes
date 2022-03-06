package all_solution.q300;

import model.ListNode;

public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next, odd = oddHead, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
