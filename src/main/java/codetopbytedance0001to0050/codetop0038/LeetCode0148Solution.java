package codetopbytedance0001to0050.codetop0038;

import struct.ListNode;

public class LeetCode0148Solution {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    // [head, tail)
    private ListNode sortList(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1Head = sortList(head, mid);
        ListNode list2Head = sortList(mid, tail);
        ListNode sorted = merge(list1Head, list2Head);
        return sorted;
    }

    private ListNode merge(ListNode h1, ListNode h2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = h1, temp2 = h2;
        while (temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


}
