/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boolexpnode;

/**
 *
 * @author Sam
 */
public class BoolOperatorNode extends BoolExpNode {

    public BoolOperatorNode(char symbol) {
        super(symbol);
        if (!(symbol == '!' || symbol == '&' || symbol == '^' || symbol == '|')) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public boolean evaluate() {
        switch (symbol) {
            case '!':
                if (rightChild != null) {
                    return !rightChild.evaluate();
                } else {
                    return !leftChild.evaluate();
                }
            case '&':
                return leftChild.evaluate() && rightChild.evaluate();
            case '^':
                return leftChild.evaluate() ^ rightChild.evaluate();
            case '|':
                return leftChild.evaluate() || rightChild.evaluate();
            default:
                throw new IllegalArgumentException();
        }
    }
}
