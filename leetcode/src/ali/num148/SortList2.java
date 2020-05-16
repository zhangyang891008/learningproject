package ali.num148;

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
public class SortList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 从底层向上合并
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head) {
        ListNode retNode = new ListNode(-1);
        retNode.next = head;
        ListNode temp = retNode.next;
        int length = 0;
        while(temp!=null){  //计算链表的长度
            length++;
            temp = temp.next;
        }


        ListNode cur ;
        ListNode tail ;
        ListNode left = null;
        ListNode right= null;
        for (int i = 1; i < length; i = i*2) {
            cur = retNode.next;  //保存切割后的剩余节点
            tail = retNode;
            while(cur!=null){
                left = cur; //前i个字符
                right = cut(cur,i); //中间i个字符
                cur = cut(right,i); //剩余字段

                tail.next = merge(left, right);  //合并左右两部分
                while(tail.next != null){  //把排序好的节点添加到链表中。
                    tail = tail.next;
                }
            }
        }

        return retNode.next;
    }

    //切割节点，去掉前step个节点，然后返回剩余的节点的链表
    private ListNode cut(ListNode head, int step){
        ListNode p = head;
        while(--step>0 && p!=null){
            p = p.next;
        }
        if(p == null)
            return null;

        ListNode next = p.next;
        p.next = null;

        return next;

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
        ListNode n5 = new ListNode(5);

        //4-2-1-3
        /*
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        */
        /*
        n3.next = n1;
        n1.next = n2;
        n2.next = n5;
        n5.next = n4;
*/
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;

        ListNode listNode = new SortList2().sortList(n4);
        System.out.println(listNode);
    }
}
