package com.no206;

/*
206. 反转链表

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */
public class ReverseList {

    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode ret = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tempNode = cur.next;
            cur.next = ret;
            ret = cur;
            cur = tempNode;
        }
        return ret;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p ;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        head.next = h1;
        ListNode h2 = new ListNode(3);
        h1.next = h2;
        ListNode h3 = new ListNode(4);
        h2.next = h3;

        ListNode listNode = new ReverseList().reverseList2(head);
        System.out.println("fin");
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}