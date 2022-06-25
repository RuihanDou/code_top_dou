package codetopbytedance0001to0050.codetop0002;

import java.util.HashMap;
import java.util.Map;

/**
 * 经典的LRU缓存算法需要双向链表和哈希map : map 控制存取， 双向链表控制capacity
 *
 * map 的 key 就是缓存 key map的value是node
 *
 * 双向链表 中的node 每被操作一次，node移动到链表头
 * put超过 capacity 就删除链表尾
 */
public class Leetcode0146LRUCache {

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
    public Leetcode0146LRUCache(int capacity){
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
