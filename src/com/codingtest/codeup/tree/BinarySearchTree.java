package com.codingtest.codeup.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = new Node(10);
        Node node1 = new Node(5);
        Node node2 = new Node(13);
        Node node3 = new Node(4);
        Node node4 = new Node(7);
        Node node5 = new Node(15);

        root.setLeftChild(node1);
        root.setRightChild(node2);

        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        node2.setRightChild(node5);
    }

    public Node getRootNode(){
        return root;
    }

    /**
     *  이진트리 탐색
     */

    //1.PreOrder(전위 순회)
    public void preOrderSearch(Node root){
        if(root !=null){
            System.out.print(root.getData() + " -> ");
            preOrderSearch(root.getLeftChild());
            preOrderSearch(root.getRightChild());
        }
    }

    //2.InOrder(중위 순회)
    public void inOrderSearch(Node root){
        if(root !=null){
            inOrderSearch(root.getLeftChild());
            System.out.print(root.getData() + " -> ");
            inOrderSearch(root.getRightChild());
        }
    }

    //3.PostOrder(후위 순회)
    public void postOrderSearch(Node root){
        if(root !=null){
            postOrderSearch(root.getLeftChild());
            postOrderSearch(root.getRightChild());
            System.out.print(root.getData() + " -> ");
        }
    }

    public void bfs(Node root){ //1.루트를 받아
        Queue<Node> queue=new LinkedList<>();   //2.큐 만들어
        queue.offer(root);  //3. 루트 넣어

        while(!queue.isEmpty()){    //4.반복 돌리는데 조건생각해
            Node node = queue.poll();       //5 꺼내
            if(node != null) {  //6.예외 or 반례
                System.out.print(node.getData() + " -> ");  //7.핵심을 구현해
                queue.offer(node.getLeftChild());           //8.다음 반복을 하기위해 행위를 하는것
                queue.offer(node.getRightChild());
            }
        }
    }

    public void dfs(Node root){
        Stack<Node> stack= new Stack<>();
        stack.push(root);

        //반복
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node != null) {
                System.out.print(node.getData() + " -> ");
                stack.push(node.getLeftChild());
                stack.push(node.getRightChild());
            }
        }

    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        Node root = binarySearchTree.getRootNode();

//        System.out.println("preOrder(전위 순회) : ");
//        binarySearchTree.preOrderSearch(root);
//        System.out.println("\n");
//
//        System.out.println("inOrder(중위 순회) : ");
//        binarySearchTree.inOrderSearch(root);
//        System.out.println("\n");
//
//        System.out.println("postOrder(후위 순회) : ");
//        binarySearchTree.postOrderSearch(root);
//        System.out.println("\n");

        System.out.println("bfs : ");
        binarySearchTree.bfs(root);
        System.out.println("\n");

        System.out.println("dfs : ");
        binarySearchTree.dfs(root);
        System.out.println("\n");
    }
}
