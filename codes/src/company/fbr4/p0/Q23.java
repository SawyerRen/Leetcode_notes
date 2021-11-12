package company.fbr4.p0;

import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int mid = l + (r - l) / 2;
        ListNode n1 = helper(lists, l, mid);
        ListNode n2 = helper(lists, mid + 1, r);
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
        if (n2 != null) cur.next = n2;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) pq.add(poll.next);
        }
        return dummy.next;
    }
}
