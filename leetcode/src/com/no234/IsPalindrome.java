package com.no234;

import java.util.Stack;

/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            if(fast.next!=null)
                fast = fast.next;

            slow = slow.next;
        }

        while(slow!=null){
            stack.push(slow);
            slow = slow.next;
        }

        slow = head;
        ListNode temp = null;
        while(slow != null && !stack.isEmpty()){
            temp = stack.pop();
            if(slow.val!= temp.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(0);

        node.next = n1;
        //n1.next = n2;
        //n2.next = n3;
        boolean palindrome = new IsPalindrome().isPalindrome(node);
        System.out.println(palindrome);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }}
