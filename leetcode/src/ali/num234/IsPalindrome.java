package ali.num234;
/*
234. 回文链表

请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 快慢指针法：在遍历的过程中，把遍历过的前半部分的节点进行反转。然后跟后半部分的节点进行比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode p  = null;
        ListNode pre = null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;

            //调整前半部分链表的排序
            p.next = pre;
            pre = p;
        }

        if(fast!=null){
            //说明链表有奇数个节点，slow在中点上。
            slow = slow.next;
        }

        while(slow!=null && pre!=null){
            if(slow.val!=pre.val){
                return false;
            }
            slow= slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;

        boolean palindrome = new IsPalindrome().isPalindrome(l1);
        System.out.println(palindrome);

    }
}
