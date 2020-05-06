package ali.num02;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.List;

/*
2. 两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    /*
    链表，注意保存结果的链表要有一个空表头，否则返回比较困难。
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ret = new ListNode(0);

        ListNode pre  = ret; //用来记录链表头位置，用来返回结果

        int carry = 0;  //记录进位情况
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        while(pointer1 != null || pointer2 != null){

            int val1 = pointer1 == null ? 0 : pointer1.val;
            int val2 = pointer2 == null ? 0 :pointer2.val;
            int sum = carry + val1 + val2;

            //进行计算并且创建节点保存结果
            ret.next = new ListNode(sum%10);
            ret = ret.next;

            carry = sum / 10;  //更新进位

            if(pointer1!= null){
                pointer1 = pointer1.next;
            }
            if(pointer2!= null){
                pointer2 = pointer2.next;
            }
        }

        //校验最高位是否有进位，如果有的话，要额外创建一个节点表示进位后的最高位
        if(carry == 1){
            ret.next = new ListNode(1);
            ret = ret.next;
        }

        return pre.next;
    }

    public static void main(String[] args) {

    }
}
