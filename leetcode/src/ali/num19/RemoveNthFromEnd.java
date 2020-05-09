package ali.num19;

import java.util.List;

/*
19. 删除链表的倒数第N个节点

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

 */
public class RemoveNthFromEnd {

    /*
    两个指针，先走N步，然后两个指针一起走，直到走到表尾部，慢指针会指向要删除节点的前驱
     */

     public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head==null)
             return null;
         ListNode pre = new ListNode(0);
         pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast!=null && fast.next!=null){ 
            fast = fast.next;
            slow = slow.next;
        }

        //目前slow指向要删除节点的前一个节点
        ListNode remove  = slow.next;
        slow.next = slow.next.next;
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode n1 = new ListNode(1);
        root.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;

        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(root, 1);
        System.out.println(listNode.val);
    }
}
