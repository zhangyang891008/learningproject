package com.ds.tree.traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的遍历
 *  a b c   c b a
 *             a
 *          b    c
 *       d  e  f  g
 *
 */
public class TreeTraverse {

    public static void main(String[] args) {
        Node head = genTree();
        preOrder(head);
        inOrder(head);
        postOrder(head);

    }

    public static Node genTree(){
        Node head = new Node("a");
        head.left = new Node("b");
        head.right = new Node("c");
        head.left.left = new Node("d");
        head.left.right = new Node("e");
        head.right.left = new Node("f");
        head.right.right = new Node("g");
        return head;
    }

    public static void preOrder(Node head){
        System.out.println("-------preOrder start-------");
        Stack<Node> stack = new Stack<>();
        if(head == null)
            return;
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println("--" + cur.value);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        System.out.println("-------preOrder end-------");
    }


    public static void inOrder(Node head){
        System.out.println("-------inOrder start-------");
        Stack<Node> stack = new Stack<>();
        if(head == null)
            return;
        Node temp = head;
        //1.找到二叉树的最左子节点
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.empty()){
            Node cur = stack.pop();
            System.out.println("removing ..." + cur.value);
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        System.out.println("-------inOrder end-------");
    }

    public static void postOrder(Node head){
        Stack<Node> valStack = new Stack<>();
        System.out.println("-------postOrder start-------");
        Stack<Node> stack = new Stack<>();
        if(head == null)
            return;
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            valStack.push(cur);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }

        while(!valStack.isEmpty()){
            System.out.println("poping ..." + valStack.pop().value);
        }

        System.out.println("-------postOrder end-------");
    }
}

class Node{
    String value;
    Node left;
    Node right;
    public Node(String value){
        this.value = value;
    }
}
