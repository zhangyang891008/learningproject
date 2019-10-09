package newcode.les05;

import java.util.Stack;

/**
 * 非递归先序遍历
 */
public class L01_PreOrder {

    public static void preOrder(Node head){
        if(head == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
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
        preOrder(head);
        System.out.println("finish");
    }
}

