/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcollection;

import java.util.AbstractCollection;
import java.util.Iterator;
import stackcollection.Stack.Node;

/**
 *
 * @author ILMAZ
 */
public class Stack<T> extends AbstractCollection<Node>{

    private Node<T> node;
    private int size;
    
    public Stack(){
        node = new Node<>(null, null);
        size = 0;
    }
    
    @Override
    public Iterator<Node> iterator() {
        return new StackIterator(node, size);
    }

    @Override
    public int size() {
        return size;
    }
    
    public void push(T obj){
        size++;
        node = new Node(obj, node);
    }
    
    public T pop(){
        T temp = node.obj;
        node = node.pred;
        return temp;
    }
    
    class Node<T>{
        public T obj;
        public Node<T> pred;
        
        public Node(T obj, Node pred){
            this.obj = obj;
            this.pred = pred;
        }
        
        @Override
        public String toString(){
            return obj.toString();
        }
    }
    
}
