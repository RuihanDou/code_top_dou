package codetopbytedance0001to0050.codetop0026;

import struct.ListNode;

public class LeetCode021SolutionIterate {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list2 == null){
            cur.next = list1;
        }
        else {
            cur.next = list2;
        }
        return dummy.next;
    }

}
