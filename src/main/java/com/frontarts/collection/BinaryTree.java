package com.frontarts.collection;

import java.util.List;

/**
 * Created by IntelliJ IDEA. @3/20/14 4:59 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class BinaryTree {

    private Node root;

    public Node find(int key) {

        Node result = find(root, key);
        if (result == null) throw new IllegalArgumentException("not found");
        return result;
    }

    private Node find(Node current, int key) {

        if (current.i == key) return current;
        else if (key < current.i) current = current.left;
        else current = current.right;
        return find(current, key);
    }

    public void insert(int key, int value) {

        insert(root, new Node(key, value));

    }

    private void insert(Node parent, Node data) {

        if (data.i < parent.i) {
            if (parent.left == null) parent.left = data;
            else {
                insert(parent.left, data);
            }
        } else {
            if (parent.right == null) parent.right = data;
            else {
                insert(parent.right, data);
            }

        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeft = true;

        // find the node;
        while (current.i != key) {
            parent = current;
            if (key < current.i) {
                isLeft = true;
                current = current.left;
            } else {
                isLeft = false;
                current = current.right;
            }
            if (current == null) return false;
        }

        // if current node is a leaf;
        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (isLeft) parent.left = null;
            else parent.right = null;
        } else
        // if current node has only left child.
        if (current.right == null) {
            if (isLeft) parent.left = current.left;
            else parent.right = current.left;
        } else
        // if current node has only right child.
        if (current.left == null) {
            if (isLeft) parent.left = current.right;
            else parent.left = current.right;
        }
        //else  current node has two children.
//        if(){
//
//        }

               return false;

    }



    public void traverse(Node node, int level, List<Double> result){

        if(node==null)return;
        if(level==0){
            result.add(node.f);

        }
        traverse(node.left,level-1,result);
        traverse(node.right,level-1,result);
    }



    public static class Node {
        int i;
        double f;
        Node left;
        Node right;

        public Node(int i, double f) {
            this.i = i;
            this.f = f;
        }
    }


}
