package ali.num148;

import java.util.List;

/*
148. 排序链表

在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
示例 1:
输入: 4->2->1->3
输出: 1->2->3->4

示例 2:
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 递归方法
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        //递归
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }


    //找中间点
    private ListNode findMid(ListNode head){

        if(head==null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast= head.next.next;

        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1 !=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
                temp.next = null;
            }else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
                temp.next = null;

            }
        }

        temp.next = l1!=null? l1:l2;

        return head.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        //4-2-1-3
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;

        ListNode listNode = new SortList().sortList(n4);
        System.out.println(listNode);
    }
}
