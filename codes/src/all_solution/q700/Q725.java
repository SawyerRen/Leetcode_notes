package all_solution.q700;

import model.ListNode;

public class Q725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int len = length / k;
        int mod = length % k;
        ListNode[] res = new ListNode[k];
        cur = head;
        int index = 0;
        while (cur != null) {
            int partLen = len;
            if (mod > 0) {
                partLen++;
                mod--;
            }
            ListNode partHead = cur;
            while (cur != null && partLen > 1) {
                cur = cur.next;
                partLen--;
            }
            res[index++] = partHead;
            if (cur == null) break;
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
