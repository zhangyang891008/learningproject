package com.interview02_02;
/*
面试题 02.02. 返回倒数第 k 个节点   >>>与interview22题相同
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4
说明：

给定的 k 保证是有效的。
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        int length = 0;

        ListNode temp = head;

        //计算链表长度
        while(temp!=null){
            length++;
            temp = temp.next;
        }

        ListNode ret = head;
        int curPos = 0;
        while((curPos+k)!=length){
            ret = ret.next;
            curPos++;
        }
        return ret.val;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}