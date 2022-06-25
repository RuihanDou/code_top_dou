package codetopbytedance0001to0050.codetop0044;

import struct.ListNode;

public class LeetCode0142SolutionFastSlow {

    // 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            } else {
                return null;
            }
            if(slow.equals(fast)){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }


}
