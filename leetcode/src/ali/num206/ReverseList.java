package ali.num206;
/*
206. 反转链表

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 方法一：头插法，迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        if(head==null || head.next == null){
            return head;
        }

        ListNode cur = res.next.next;
        res.next.next = null;
        ListNode temp = null;
        while(cur!=null){
            temp = cur;
            cur = cur.next;
            //头插法
            temp.next = res.next;
            res.next = temp;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode listNode = new ReverseList().reverseList(l1);
        System.out.println(listNode);
    }
}
