package ali.num146;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.List;

/**
 * 146. LRU缓存机制

 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  --缓存容量 -- )
 *
 *         *cache.put(1,1);
 *         *cache.put(2,2);
 *         *cache.get(1);       // 返回  1
 *         *cache.put(3,3);    // 该操作会使得密钥 2 作废
 *         *cache.get(2);       // 返回 -1 (未找到)
 *         *cache.put(4,4);    // 该操作会使得密钥 1 作废
 *         *cache.get(1);       // 返回 -1 (未找到)
 *         *cache.get(3);       // 返回  3
 *         *cache.get(4);       // 返回  4
 */
public class LRU {

    /*
    map + 双向链表
     */

    static class ListNode{
        int value;
        int key;
        ListNode pre;
        ListNode next;
    }

    static class LRUCache {
        int size = 0;
        int capacity;

        HashMap<Integer,ListNode> values = new HashMap<>();
        ListNode head = new ListNode();  //设置一个空的头结点
        ListNode tail = new ListNode();



        public LRUCache(int capacity) {
            this.capacity = capacity;

            head.value=-1;
            tail.value = -2;
            head.next = tail;
            tail.pre = head;
        }

        public void removeNode(ListNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre= null;
            node.next = null;
        }

        public void addNode(ListNode node){
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }


        public int get(int key) {

            ListNode listNode = values.get(key);
            if(listNode!=null){
                removeNode(listNode);
                addNode(listNode);
                return listNode.value;
            }

            return -1;
        }

        public void put(int key, int value) {
            ListNode curNode = values.get(key);
            if(curNode == null){
                //新增节点
                ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.value = value;

                //更新map
                values.put(key, newNode);

                //插入一个节点到表头
                addNode(newNode);

                if(size >= capacity){
                    //移除末尾的节点
                    ListNode pre = tail.pre;
                    values.remove(pre.key);
                    removeNode(pre);
                    pre = null;
                }else{
                    size++;
                }

            }else{
                //替换旧的节点
                removeNode(curNode);
                curNode.value = value;
                addNode(curNode);
                values.put(key,curNode);
            }

        }
    }

    public static void main(String[] args) {

/*
            //test1
        LRUCache cache = new LRUCache(2);
            cache.put(1,1);
            cache.put(2,2);
        System.out.println(cache.get(1));;       // 返回  1
            cache.put(3,3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));;        // 返回 -1 (未找到)
            cache.put(4,4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));;          // 返回 -1 (未找到)
        System.out.println(cache.get(3));;         // 返回  3
        System.out.println(cache.get(4));;         // 返回  4
 */

    /*
     //test2
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));


     */

/*
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        int i = lruCache.get(2);
        System.out.println(i);


 */
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
