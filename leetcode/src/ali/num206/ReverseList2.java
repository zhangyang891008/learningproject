package ali.num206;
/*
206. 反转链表

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 方法二：递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        /*
        例如：1->2->3->4
        reverse后：4->3->2 , 1->2 即p为4对应的节点，1为head,2为head.next
         */
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode listNode = new ReverseList2().reverseList(l1);
        System.out.println(listNode);
    }
}
