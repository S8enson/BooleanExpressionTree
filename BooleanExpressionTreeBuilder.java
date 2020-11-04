/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boolexpnode;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class BooleanExpressionTreeBuilder {

    static int numNodes;

    public static BoolExpNode buildExpressionTree(char[] expression) {
        Stack<BoolExpNode> stack = new Stack();
        BoolOperatorNode operatorNode;

        for (int i = 0; i < expression.length; i++) {
            if (isOperand(expression[i])) {
                stack.push(new BoolOperandNode(expression[i]));
            } else if (isOperator(expression[i])) {
                
                operatorNode = new BoolOperatorNode(expression[i]);
                operatorNode.rightChild = stack.pop();
                if(expression[i] != '!'){
                operatorNode.leftChild = stack.pop();
                }
                

                stack.push(operatorNode);

            } else {
                throw new IllegalArgumentException();
            }
        }

        return stack.pop();
    }

    public static String toInfixString(BoolExpNode node) {
        if (node == null) {
            return "";
        } else if((node.leftChild == null && node.rightChild==null) || node.symbol == '!'){
            return toInfixString(node.leftChild)+node+toInfixString(node.rightChild);
        }else {
        return "("+toInfixString(node.leftChild)+node+toInfixString(node.rightChild)+")";
        }
    }

    public static int countNodes(BoolExpNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodes(node.leftChild) + countNodes(node.rightChild);
        }
    }

    public static boolean isOperand(char symbol) {
        if (symbol == 'T' || symbol == 'F') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOperator(char symbol) {
        if (symbol == '!' || symbol == '&' || symbol == '^' || symbol == '|') {
            return true;
        } else {
            return false;
        }
    }
}
