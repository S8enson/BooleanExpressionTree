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
public abstract class BoolExpNode {

    /**
     * @param args the command line arguments
     */
protected char symbol;
public BoolExpNode leftChild;
public BoolExpNode rightChild;

public BoolExpNode(char symbol){
this.symbol = symbol;
leftChild = null;
rightChild = null;
}

public abstract boolean evaluate();

@Override
public String toString(){
return Character.toString(symbol);
}


    
}
