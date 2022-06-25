package codetopbytedance0051to0100.codetop0051;

import struct.ListNode;

public class LeetCode082Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head), cur = dummy;

        while(cur.next != null && cur.next.next != null){
            // 出现重复，把所有重复都找出来
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


}
