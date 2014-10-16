package com.frontarts.collection;

/**
 * Created by IntelliJ IDEA. @3/19/14 1:59 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Stack {

    private int size;
    private char[] array;
    private int top;

    public Stack(int size) {
        this.size = size;
        array = new char[size];
        top = -1;
    }

    public void push(char c) {
        if (top < size)
            array[++top] = c;
        else throw new IllegalArgumentException("stack of size <" + size + "> is full");
    }

    public char pop() {
        if (!isEmpty())
            return array[top--];
        else throw new IllegalArgumentException("no element anymore");
    }

    public int size(){
        return top+1;
    }

    public char peekN(int i){
        return array[i];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void displayStack(String hint){
        System.out.println(hint);
        System.out.print("stack [bottom -->top]:");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println("");
    }

    public char peek() {
        return array[top];
    }

    protected interface InterFaceA{}
}
