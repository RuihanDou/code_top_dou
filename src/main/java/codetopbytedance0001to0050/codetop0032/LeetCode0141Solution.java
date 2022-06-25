package codetopbytedance0001to0050.codetop0032;

import struct.ListNode;

public class LeetCode0141Solution {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

}
