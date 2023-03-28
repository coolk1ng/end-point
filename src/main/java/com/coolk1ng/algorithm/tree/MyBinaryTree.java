package com.coolk1ng.algorithm.tree;

import org.springframework.util.CollectionUtils;

import java.util.LinkedList;

/**
 * 二叉树
 *
 * @author coolk1ng
 * @since 2023/3/13 15:39
 */
public class MyBinaryTree {
    public static TreeNode createBinaryTree(LinkedList<Integer> initList) {
        TreeNode node = null;
        if (CollectionUtils.isEmpty(initList)) return null;

        Integer data = initList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(initList);
            node.rightChild = createBinaryTree(initList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(null);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        TreeNode binaryTree = createBinaryTree(linkedList);
        for (int i = 0; i < 10; i++) {
            System.out.println(binaryTree);
        }
    }
}

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    public TreeNode(int data) {
        this.data = data;


    }
}
