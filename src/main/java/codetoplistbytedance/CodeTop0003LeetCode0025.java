package codetoplistbytedance;

import struct.ListNode;


public class CodeTop0003LeetCode0025 {

    /**
     *
     * @param head
     * @param tail
     * @return      返回的[] 0 位上是反转后的 head;
     *                      1 位上是反转后的 tail;
     */
    private ListNode[] reverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        // 循环体内部
        // 1、找到 head -> tail 长度位k 的链表区间[head, ...., tail]
        // 2、反转 链表
        // 3、把反转子区间连接回原链表
        // 4、更新符号 满足 下一次循环
        while (head != null){
            ListNode tail = prev;
            // 查看剩余部分的长度是否大于或者等于k
            for(int i = 0; i < k; i++){
                tail = tail.next;
                // 长度不满足 k 就不进行反转了
                if(tail == null){
                    return dummyHead.next;
                }
            }
            // 使用 next 记录 该组后面的 链表 头，反转组内
            ListNode next = tail.next;
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];
            // 把反转的子链连接回链表中
            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }

        return dummyHead.next;
    }

}
