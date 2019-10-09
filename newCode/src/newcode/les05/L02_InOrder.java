package newcode.les05;

import java.util.Stack;

/**
 * 非递归实现中序遍历:只要左孩子存在就一直入栈，如果为空，出栈元素并打印，然后指向右孩子
 */
public class L02_InOrder {

    public static void inOrder(Node head){
        if(head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(!stack.isEmpty() || cur!=null ){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            Node pop = stack.pop();
            System.out.println(pop.val);
            cur = pop.right;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head.left = n1;
        head.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        inOrder(head);
        System.out.println("finish");
    }
}
