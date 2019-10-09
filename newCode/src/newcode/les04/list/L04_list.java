package newcode.les04.list;

/**
 * 判断两个链表交点：
 * 1先判断是否成环：一个成环，一个不成环是不可能相交的
 * 2如果两个都成环：2.1如果两个交点相同，直接返回；2.2如果两个交点不同，选择任意一个交点，循环遍历一圈如果都没有遇到另一个交点，说明不相交返回null，如果遇到另一个交点，任选一个返回；
 * 3如果两个都不成环：要统一两个链表的长度和尾节点，如果尾节点是不同的一定没有交点；如果尾节点相同，将比较长的链表遍历到和另一个链表相同的长度，然后一起遍历，找到交点
 */
public class L04_list {



    public static Node judge(Node l1, Node l2){
        Node loop1 = hasCircle(l1);
        Node loop2 = hasCircle(l2);

        //1.无环的情况下求交点
        if(loop1 == null && loop2==null){
            //无环判断
            Node temp1 = l1;
            Node temp2 = l2;
            Node end1 = null;
            Node end2 = null;
            int length1 = 0;
            int length2 = 0;

            while(temp1!=null){
                end1 = temp1;
                length1++;
                temp1 = temp1.next;
            }
            while(temp2!= null){
                end2 = temp2;
                length2++;
                temp2 = temp2.next;
            }
            //尾节点不相同，不可能相交。
            if(end1!=end2)
                return null;

            if(length1 < length2){
                while(length2!=length1){
                    l2 = l2.next;
                    length2--;
                }
            }else{
                while(length1!=length2){
                    l1 = l1.next;
                    length1--;
                }
            }
            //从长度相同的位置开始，找交点
            while(true){
                l1 = l1.next;
                l2 = l2.next;
                if(l1 == l2)
                    return l1;
            }

        }else if(loop1 == null || loop2 == null){
            //2.有一个为环，一个不成环，是不会有交点的
            return null;
        }else{
            //3.都成环
            //3.1成环之前已经相交了
            if(loop1==loop2){
                return loop1;
            }
            //3.2成环之前不相交，要判断下成环后两个交点是否在一个环上，如果不在就是不相交
            Node temp = loop1.next;
            while(temp != loop1){
                if(temp == loop2){
                    return loop2;
                }
                temp = temp.next;
            }
            //回到了原点，走了一圈也没有遇到loop2，说明两个环不是同一个。
            return null;

        }

    }

    //快慢指针相遇法,找到环的开始位置，如果没有成环返回null;
    private static Node hasCircle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null){
            if(fast.next==null ||fast.next.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;

            //相遇，fast回到起点，每次走一步，相遇位置就是交点
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        //有环fast是不会为空的！
        return null;
    }

    public static void main(String[] args) {
        Node h1 = new Node("h1");
        Node h2 = new Node("h2");
        Node h3 = new Node("h3");
        Node h4 = new Node("h4");


        Node h5 = new Node("h5");
        Node h6 = new Node("h6");
        Node h7 = new Node("h7");
        Node h8 = new Node("h8");
        /**
         //情况1：两个环，不相交
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h3;

        h5.next = h6;
        h6.next = h7;
        h7.next = h8;
        h8.next = h6;
        judge(h1,h5);
         */

        /*
        //情况2：无环相交
        h1.next= h2;
        h2.next = h3;
        h3.next = h8;

        h4.next = h5;
        h5.next = h6;
        h6.next = h3;
        System.out.println(judge(h1,h4).val);
        */

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h3;

        h6.next = h7;
        h7.next = h8;
        h8.next = h4;
        System.out.println(judge(h1,h6).val);
    }
}

class Node{
    String val;
    Node next;
    public Node(String val){
        this.val = val;
    }
}