package newcode.les04;

public class L03_FlagProblem {

    public static void flag(FlagNode head, int val){
        if(head==null){
            return;
        }
        FlagNode less = null;
        FlagNode equal = null;
        FlagNode more = null;
        FlagNode lessEnd = less;
        FlagNode equalEnd = equal;
        FlagNode moreEnd = more;
        FlagNode temp = head.next;
        //第一次循环，找到大于等于小于val的第一个元素
        FlagNode before = head;
        while(temp!= null){
            if(temp.val < val){
                if(less == null){
                    lessEnd = less = temp;
                    before.next = temp.next;
                    temp = before.next;
                    lessEnd.next = null;
                }else{
                    before = temp;
                    temp = temp.next;
                }
            }else if(temp.val == val){
                if(equal ==null){
                    equalEnd = equal = temp;
                    before.next = temp.next;
                    temp = before.next;
                    equalEnd.next = null;
                }else{
                    before = temp;
                    temp = temp.next;
                }
            }else{
                if(more == null){
                    moreEnd = more = temp;
                    before.next = temp.next;
                    temp = before.next;
                    moreEnd.next = null;
                }else{
                    before = temp;
                    temp = temp.next;
                }
            }

        }

        temp = head.next;
        while(temp!=null){
            if(temp.val<val){
                if(temp!=less){
                    lessEnd.next = temp;
                    lessEnd = temp;
                }
            }else if(temp.val == val){
                if(temp!=equal){
                    equalEnd.next = temp;
                    equalEnd = temp;
                }
            }else{
                if(temp!=more){
                    moreEnd.next = temp;
                    moreEnd = temp;
                }
            }
            temp = temp.next;
        }
        FlagNode first= null;
        FlagNode tail = null;
        if(less!= null){
            first = less;
            tail = lessEnd;
        }
        if(equal!=null){
            if(first==null){
                first = equal;
            }else{
                tail.next = equal;
            }
            tail = equalEnd;
        }
        if(more!=null){
            if(first == null){
                first = more;
            }else{
                tail.next = more;
            }
            tail = moreEnd;
        }

        head = first;
    }

    public static void main(String[] args) {

        FlagNode head = new FlagNode(0);
        FlagNode n1 = new FlagNode(5);
        FlagNode n2 = new FlagNode(2);
        FlagNode n3 = new FlagNode(8);
        FlagNode n4 = new FlagNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        flag(head, 5);
        System.out.println(head);
    }
}

class FlagNode{
    int val;
    FlagNode next;
    public FlagNode(int val){
        this.val = val;
    }
}