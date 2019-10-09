package newcode.les04.copylist;

import java.util.HashMap;

/**
 * 拷贝一个特殊的链表：链表包括值，后继节点、和随机节点（随机指向一个节点）
 *
 */
public class L05_copyList {

    //方法一：用hashMap保存新旧链表的对应关系 辅助空间O(n)
    public static RandomNode copy(RandomNode head){
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        //System.out.println(map.get(null));
        RandomNode temp = head;
        while(temp!=null){
            map.put(temp, new RandomNode(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp!= null){
            RandomNode cur = map.get(temp);
            RandomNode next = map.get(temp.next);
            RandomNode random = map.get(temp.random);
            cur.next = next;
            cur.random = random;
            temp = temp.next;
        }
        return map.get(head);
    }

    //方法2：不使用辅助空间,把拷贝节点插入原节点的后续节点，通过前驱后继节点关系定位
    public static RandomNode copy2(RandomNode head){
        RandomNode temp = head;

        while(temp!=null){
            RandomNode newNode = new RandomNode(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null){
            RandomNode cur = temp.next;
            cur.random = (temp.random == null) ? null:temp.random.next; //注意判断空的情况，random为空直接赋空值
            temp=temp.next.next;
        }
        temp = head;
        RandomNode copy = new RandomNode(0);
        RandomNode tail = copy;
        while(temp!=null){
            tail.next = temp.next;
            tail = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return copy.next;

    }

    public static void main(String[] args) {
        RandomNode head = new RandomNode(1);
        RandomNode h1 = new RandomNode(11);
        RandomNode h2 = new RandomNode(22);
        head.next = h1;
        head.random = h2;
        h1.next = h2;
        h1.random = h2;
        //h2.random = h1;

        //RandomNode copy = copy(head);
        RandomNode randomNode = copy2(head);
        System.out.println("finish");

    }
}

class RandomNode{
    int val;
    RandomNode next;
    RandomNode random;
    public RandomNode(int val){
        this.val = val;
    }
}