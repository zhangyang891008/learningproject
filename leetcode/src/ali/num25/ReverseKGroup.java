package ali.num25;

/*
25. K 个一组翻转链表

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：

给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode fast = temp.next; //查找下一个开始翻转节点的第一个节点
        ListNode slow =  temp.next; //slow节点的是开始反转的的第一个节点，slow-fast之间的节点需要通过尾插法插入到preSlow节点后面
        ListNode preSlow = temp; //保存slow的前一个节点，用来进行节点尾插法插入
        ListNode remove; //保存要移动的节点
        int count = 0;
        while(fast!= null){
            count++;
            fast = fast.next;

            //遍历了K个数
            if(count == k){
                //开始移动节点，把slow和fast之间的节点插入到slow前
                while(slow.next != fast){
                    remove = slow.next;
                    slow.next = slow.next.next;
                    remove.next = preSlow.next;
                    preSlow.next = remove;
                }

                preSlow = slow;
                slow = fast;
                count = 0;

            }
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = new ReverseKGroup().reverseKGroup(n1, 2);
        System.out.println(listNode);
    }
}
