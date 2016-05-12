/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcollection;

import java.util.Iterator;
import stackcollection.Stack.Node;

/**
 *
 * @author ILMAZ
 */
public class StackIterator implements Iterator<Node>{

    private Node node;
    private final int size;
    private int state;
    
    public StackIterator(Node node, int size){
        this.node = node;
        this.size = size;
        state = 0;
    }
    
    @Override
    public boolean hasNext() {
        return state < size;
    }

    @Override
    public Node next() {
        Node temp = node;
        node = node.pred;
        state++;
        return temp;
    }
    
}
