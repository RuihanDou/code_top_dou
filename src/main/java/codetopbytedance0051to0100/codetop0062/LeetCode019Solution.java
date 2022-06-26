package codetopbytedance0051to0100.codetop0062;

import struct.ListNode;

public class LeetCode019Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            throw new IllegalArgumentException(" n == 0 is illegal");
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pioneer = dummy, cur = dummy;

        // start 先向前移动 n
        while (n != 0) {
            if(pioneer.next != null) {
                pioneer = pioneer.next;
                n--;
            } else {
                throw new IllegalArgumentException("n is beyond the list node's size");
            }

        }
        // end 和 start 共同向前移动到 start 到最后的节点
        while (pioneer.next != null) {
            pioneer = pioneer.next;
            cur = cur.next;
        }
        // 删除掉此时的end的节点
        cur.next = cur.next.next;
        return dummy.next;
    }

}
