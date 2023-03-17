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
        if (data == null) return null;
        node = new TreeNode(data);
        node.leftChild = createBinaryTree(initList);
        node.rightChild = createBinaryTree(initList);
        return node;
    }
}

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }
}
