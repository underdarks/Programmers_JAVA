package com.codingtest.codeup.tree;


public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;


    //생성자
    public Node(int data) {
        this.data = data;
        this.leftChild=null;
        this.rightChild=null;
    }

    /**
     *  getter, setter
     *
     */
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
