package codetopbytedance0001to0050.codetop0024;

import struct.ListNode;

public class LeetCode0143SolutionSteps {

    /**
     * 1、 找到链表的中点
     * 2、 链表中点，之后的部分，翻转链表（中点 的 next 要置空）
     * 3、 合并链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        // 注意把mid的next置空
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private void mergeList(ListNode l1, ListNode l2){
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null){
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;
            l2.next = l1;
            l2 = l2Tmp;
        }
    }


}
