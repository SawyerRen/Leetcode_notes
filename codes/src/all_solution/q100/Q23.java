package all_solution.q100;

import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid + 1, end);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
//        for (ListNode head : lists) {
//            if (head != null) pq.add(head);
//        }
//        ListNode dummy = new ListNode();
//        ListNode cur = dummy;
//        while (!pq.isEmpty()) {
//            ListNode poll = pq.poll();
//            cur.next = poll;
//            if (poll.next != null) pq.add(poll.next);
//            cur = cur.next;
//        }
//        return dummy.next;
//    }
}
