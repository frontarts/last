package com.frontarts.algorithm;

import com.frontarts.collection.Stack;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA. @3/19/14 2:11 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class InfixTranslation {

    private Stack ops;

    private String output="";

    public void in2post(String input) {
        ops = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            ops.displayStack("for " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOp(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOp(ch, 2);
                    break;
                case '(':
                    ops.push(ch);
                    break;
                case ')':
                    gotParenthesis(ch);
                    break;
                default:
                    output += ch;
                    break;
            }
        }
        while (!ops.isEmpty()){
            ops.displayStack("while: ");
            output += ops.pop();
        }
        ops.displayStack("end");
    }

    private void gotParenthesis(char ch) {
        while (!ops.isEmpty()) {
            char top = ops.pop();
            if (top == '(') break;
            else output += top;

        }
    }

    private void gotOp(char op, int prec1) {
        while (!ops.isEmpty()) {
            char top = ops.pop();
            if (top == '(') {
                ops.push(top);
                break;
            } else {
                int prec2;
                if (top == '+' || top == '-') prec2 = 1;
                else prec2 = 2;

                if (prec2 < prec1) {
                    ops.push(top);
                    break;
                } else output += top;
            }
        }
        ops.push(op);

    }

    @Test
    public void tt(){
        String expression ="a+b-c*(d+e)";
        InfixTranslation test = new InfixTranslation();
        test.in2post(expression);
        System.out.printf(test.output);
    }

}
