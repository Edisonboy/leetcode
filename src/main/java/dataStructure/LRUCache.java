package dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zzh
 * create at:  2020/8/6
 * @description:no.146 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* capacity  );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    private int size;

    private int capacity;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;


    public static class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;


        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int val = map.get(key).val;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // 更新value
            node.val = value;
            remove2Head(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            // 加到头结点中
            add2Head(node);
            size++;
            if (size > capacity) {
                node = removeTail();
                map.remove(node.key);
                size--;
            }
        }
    }

    public Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public void remove2Head(Node node) {
        removeNode(node);
        add2Head(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add2Head(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
