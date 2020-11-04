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
public class BoolOperandNode extends BoolExpNode {

    public BoolOperandNode(char symbol) {
        super(symbol);
        if (!(symbol == 'T' || symbol == 'F')) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public boolean evaluate() {
        if (symbol == 'T') {
            return true;
        } else {
            return false;
        }
    }
}
