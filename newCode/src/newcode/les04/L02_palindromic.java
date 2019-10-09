package newcode.les04;

import java.util.Stack;

/**
 * 判断一个链表是否是回文2：通过一个栈缓存后半部分数据，然后出栈与前半部分数据比对的方法判断，栈大小为n/2，空间复杂度为O(n/2)
 */
public class L02_palindromic {

    public static boolean palindromic(StrNode head){
        if(head == null){
            return true;
        }

        StrNode fast = head;
        StrNode slow = head;

        Stack<String> stack = new Stack<>();

        while(fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }

        while(slow!=null){
            stack.push(slow.val);
            slow = slow.next;
        }

        while(!stack.isEmpty()){
            String pop = stack.pop();
            if(!pop.equals(head.val))
                return false;
            head = head.next;

        }

        return true;
    }

    public static void main(String[] args) {

        StrNode head = new StrNode("a");
        StrNode n1 = new StrNode("b");
        StrNode n2 = new StrNode("b");
        StrNode n3 = new StrNode("a");
        //Node n4 = new Node(8);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;

        System.out.println(palindromic(head));;
    }
}

class StrNode{
    String val;
    StrNode next;
    public StrNode(String val){
        this.val = val;
    }
}