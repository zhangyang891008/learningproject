package newcode.les04;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断链表是否是回文
 */
public class L01_palindromic {

    public static boolean palindromic(Node head){
        if(head == null){
            return true;
        }
        Node first = head;
        Node fast = head;
        Node slow = head;
        //slow找到中点
        while(fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }
/*
        System.out.println(slow.val);
        System.out.println(fast.val);

*/
        Node nextPtr = slow.next;
        slow.next = null;

        Node tail = slow;

        while(nextPtr!=null){
            Node temp = nextPtr;
            nextPtr = nextPtr.next;
            //标记后半部分链表反转过程中的尾指针
            temp.next = tail;
            tail = temp;
        }


        while(first!= null && fast!=null){
            if(first.val!=fast.val){
                return false;
            }
            first = first.next;
            fast = fast.next;
        }

        //恢复现场
        //TODO



        return true;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(0);
        Node n2 = new Node(1);
       // Node n3 = new Node(1);
        //Node n4 = new Node(8);
        head.next = n1;
        n1.next = n2;
       // n2.next = n3;
       // n3.next = n4;

        System.out.println(palindromic(head));;

    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}