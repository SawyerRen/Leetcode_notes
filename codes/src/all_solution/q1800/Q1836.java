package all_solution.q1800;

import model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Q1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        cur = dummy;
        while (cur.next != null) {
            if (map.get(cur.next.val) > 1) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
