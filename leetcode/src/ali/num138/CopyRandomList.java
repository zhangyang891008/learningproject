package ali.num138;

import java.util.HashMap;
import java.util.Map;

/*
138. 复制带随机指针的链表

给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。

示例 1：

输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：

输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。

 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 方法一：通过map缓存新旧节点之间的对应关系，第一次循环创建新链表，第二次循环添加随机节点
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node oldNode = head;
        Node retNode = new Node(-2);
        Node pre = retNode;

        //拷贝链表，缓存新旧节点对应关系
        Map<Node,Node> map = new HashMap<>();
        while(oldNode!=null){
            Node newNode = new Node(oldNode.val);
            map.put(oldNode, newNode);
            pre.next = newNode;
            pre = newNode;

            oldNode = oldNode.next;
        }

        pre = retNode.next;
        oldNode = head;

        while (oldNode!=null){
            if(oldNode.random!=null){
                pre.random = map.get(oldNode.random);
            }

            oldNode = oldNode.next;
            pre = pre.next;
        }

        return retNode.next;
    }

    /**
     * 方法二：第一次循环新创建的复制节点插入到被复制的节点的后继，第二次循环，把随机节点指定；然后把新节点从旧节点重拆出来
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        Node temp = head;
        //第一次循环，插入新节点
        while(temp!=null){
            Node newNode= new Node(temp.val);
            newNode.next =  temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        //第二次循环，给新节点指定随机节点
        temp = head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random = temp.random.next;

            temp = temp.next.next;
        }

        Node retNode = new Node(-1);
        Node retTemp = retNode;
        temp = head;

        while(temp!=null){
            Node next = temp.next;
            temp.next = temp.next.next;

            retTemp.next = next;
            retTemp = next;
            next.next = null;

            temp = temp.next;
        }
        return retNode.next;
    }

    public static void main(String[] args) {

    }

}
