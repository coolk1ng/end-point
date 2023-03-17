package com.coolk1ng.algorithm.list;

/**
 * 链表操作
 * @author coolk1ng
 * @since 2023/3/10 17:08
 */
public class MyLinkedList {
    //头节点
    private Node head;
    //尾节点
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 插入
     */
    public void insert(int data, int index) {
        //超出节点范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出节点范围...");
        }

        Node node = new Node(data);
        if (size == 0) {
            //空链表
            head = node;
            last = node;
        } else if (index == 0) {
            //插入头部
            node.next = head;
            head = node;
        } else if (index == size - 1) {
            //尾插入
            last.next = node;
            last = node;
        } else {
            Node preNode = getNode(index - 1);
            Node nextNode = preNode.next;
            preNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    /**
     * 删除
     */
    public Node remove(int index) {
        //超出节点范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出节点范围...");
        }

        Node removeNode = null;

        if (index == 0) {
            //删除头节点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾节点
            Node preNode = getNode(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        } else {
            //中间删除
            Node preNode = getNode(index - 1);
            removeNode = preNode.next;
            Node nextNode = removeNode.next;
            preNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    /**
     * 链表查找元素
     */
    public Node getNode(int index) {
        //超出节点范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出节点范围...");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出
     */
    public void outPut() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1, 0);
        linkedList.insert(2, 1);
        linkedList.insert(3, 2);
        linkedList.outPut();
        System.out.println("------------------");
        Node remove = linkedList.remove(1);
        System.out.println("删除的元素:" + remove.data);
        linkedList.outPut();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

