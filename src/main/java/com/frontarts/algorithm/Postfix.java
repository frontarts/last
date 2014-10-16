package com.frontarts.algorithm;

/**
 * Created by IntelliJ IDEA. @7/28/2014 11:43 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class Postfix {

}

class ParshPost {
    private StackX stackX;
    private String input;

    public int doParse() {
        stackX = new StackX(20);
        char ch;
        int j;
        int operandA, operandB, interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            stackX.displayStack(String.format("==$s==", ch));
            if (ch >= '0' && ch <= '9') stackX.push(ch);
            else {
                operandA = stackX.pop();
                operandB = stackX.pop();
                switch (ch) {
                    case '+':
                        interAns = operandA + operandB;
                    case '-':
                        interAns = operandA - operandB;
                    case '*':
                        interAns = operandA * operandB;
                    case '/':
                        interAns = operandA / operandB;
                    default:
                        interAns = 0;
                }
                stackX.push(interAns);
            }
        }
        return stackX.pop();
    }
}

class StackX {
    private int maxSize;
    private int[] array;
    private int top;

    StackX(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        top = -1;

    }

    public void push(int j) {
        array[++top] = j;
    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public int peekN(int n) {
        return array[n];
    }

    public void displayStack(String label) {

        System.out.println(label);
        System.out.println("Stack [bottom-->top]): ");
        for (int i : array) {
            System.out.println(peekN(i));
        }
    }
}

