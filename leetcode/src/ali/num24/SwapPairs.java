package ali.num24;

import java.util.List;

/*
24. 两两交换链表中的节点

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    /**
     * 分成奇偶数；把一个链表根据奇偶位置拆分成两个链表，然后插入新的链表中
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if(head == null){
            return null;
        }
        if(head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = new ListNode(-2);
        ListNode evenTail = even;

        while(odd != null && odd.next != null){
            ListNode remove = odd.next;
            odd.next = odd.next.next;

            evenTail.next = remove;
            evenTail = remove;
            remove.next = null;
            odd = odd.next;
        }

        odd = head;
        even = even.next;
        ListNode retNode = new ListNode(-1);
        ListNode retTail = retNode;

        int index = 1;
        ListNode temp = null;
        while(odd!=null || even!=null){
            index++;
            if(index%2 == 1){
                temp = odd;
                odd = odd.next;
            }else{
                if(even == null){  //因为偶数放在前面，有可能偶数个数小于奇数，会为空
                    continue;
                }
                temp = even;
                even = even.next;
            }

            retTail.next = temp;
            retTail = temp;
            temp.next = null;

        }

        return retNode.next;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode listNode = new SwapPairs().swapPairs(n1);

        System.out.println("...."+listNode);
    }
}
