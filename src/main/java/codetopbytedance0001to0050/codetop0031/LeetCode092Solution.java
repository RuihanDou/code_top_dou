package codetopbytedance0001to0050.codetop0031;

import struct.ListNode;

public class LeetCode092Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        // pre 到 第 left - 1 的位置
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        // cur 是 第 left 的位置
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0; i < right - left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

}
