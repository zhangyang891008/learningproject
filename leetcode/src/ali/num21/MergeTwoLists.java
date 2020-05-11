package ali.num21;

/*
21. 合并两个有序链表

将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode root = new ListNode(-1);
        ListNode tail = root;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
                tail.next = null;
            }else{
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
                tail.next = null;
            }
        }

        while(l1 != null){
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
            tail.next = null;
        }

        while(l2 != null){
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
            tail.next = null;
        }
        return root.next;
    }

    /*
    方法2：题解里的写法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode result = new ListNode(-1);
        ListNode pre = result;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next= l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = ( l1==null?l2:l1);
        return result.next;

    }

    public static void main(String[] args) {
        
    }
}
