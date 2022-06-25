package codetopbytedance0051to0100.codetop0058;

import struct.ListNode;


/**
 * 排序奇升偶降链表
 *
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 *
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 */
public class OddEvenListSortSolution {

    public ListNode sortOddEvenList(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode headOdd = head;
        ListNode headEven = head.next;
        while (headEven != null && headEven.next != null){
            headOdd.next = headEven.next;
            headOdd = headOdd.next;
            headEven.next = headOdd.next;
            headEven = headEven.next;
        }
        // 奇数位最后指有东西，偶数位最后指向空
        headOdd.next = null;

        headEven = reverse(headEven);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (headOdd != null && headEven != null){
            if(headOdd.val <= headEven.val){
                cur.next = headOdd;
                headOdd = headOdd.next;
            }
            else {
                cur.next = headEven;
                headEven = headEven.next;
            }
            if(headOdd != null){
                cur.next = headOdd;
            }
            if(headEven != null){
                cur.next = headEven;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode preNode = null;
        ListNode curNode = head;

        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }


}
