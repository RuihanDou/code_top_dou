package codetoplistbytedance;

import struct.ListNode;

public class CodeTop0004LeetCode0206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode reserve = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reserve;
    }

}
