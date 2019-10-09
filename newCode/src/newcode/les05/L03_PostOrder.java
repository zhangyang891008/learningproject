package newcode.les05;

import java.util.Stack;

public class L03_PostOrder {

    public static void postOrder(Node head){
        if(head == null)
            return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> cacheStack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            cacheStack.push(cur);
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }

        while(!cacheStack.isEmpty()){
            System.out.println(cacheStack.pop().val);
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
        postOrder(head);

    }
}