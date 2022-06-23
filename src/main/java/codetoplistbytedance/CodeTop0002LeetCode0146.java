package codetoplistbytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class CodeTop0002LeetCode0146 {
    /**
     * 经典的LRU缓存算法需要双向链表和哈希map
     *
     * map 的 key 就是缓存 key map的value是node
     *
     * 双向链表 中的node 每被操作一次，node移动到链表头
     * put超过 capacity 就删除链表尾
     */

    private class DoublyLinkedNode{
        int key;
        int val;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        public DoublyLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    Map<Integer, DoublyLinkedNode> map;
    int capacity;

    /**
     * 初始化LRU缓存，建立双向链表，双向链表的表示是由头和尾构成
     *
     * @param capacity
     */
    public CodeTop0002LeetCode0146(int capacity) {
        head = new DoublyLinkedNode(0, 0);
        tail = new DoublyLinkedNode(0, 0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * 插入双向链表总是从 head 一端
     * @param node
     */
    private void insertQueue(DoublyLinkedNode node){
        DoublyLinkedNode oldFirst = head.next;
        // 和 双向链表头相连
        head.next = node;
        node.prev = head;
        // 和 oldFirst相连
        oldFirst.prev = node;
        node.next = oldFirst;
    }

    /**
     * 删除 节点，知道该节点，把该节点从链表中删除
     *
     * 把该节点从 map 中删除
     * @param node
     */
    private void delete(DoublyLinkedNode node){
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
        node = null;
    }

    /**
     * add的时候要考虑容量，超过容量删除 tail 端的node
     *
     * @param newNode
     */
    private void add(DoublyLinkedNode newNode){
        insertQueue(newNode);
        map.put(newNode.key, newNode);
        if(map.size() > capacity){
            DoublyLinkedNode toDelete = tail.prev;
            delete(toDelete);
        }
    }

    /**
     *  get 操作， 每get操作一次，get 对应的node 就移动到head端
     * @param key
     * @return
     */
    public int get(int key) {
        if(map.containsKey(key)){
            DoublyLinkedNode node = map.get(key);
            delete(node);
            add(node);
            return node.val;
        }
        else {
            return -1;
        }
    }

    /**
     * put 操作，如果没有 key 那么 add
     *          如果有 key 那么 删除node 修改node value 再添加node
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)){
            DoublyLinkedNode cur = map.get(key);
            delete(cur);
            cur.val = value;
            add(cur);
        }
        else {
            DoublyLinkedNode newNode =new DoublyLinkedNode(key, value);
            add(newNode);
        }
    }

}
