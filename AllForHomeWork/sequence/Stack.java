/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

/**
 *
 * @author ILMAZ
 */
public class Stack {
    private Node node;
    private int n = 0;
    
    class Node{
        public Object obj;
        public Node objPred;
        public Node(Object obj, Node objPred){
            this.obj = obj;
            this.objPred = objPred;
        }
    }
    
    
    public Stack(){
        node = new Node(null, null);
    }
    public void push(Object obj){
        node = new Node(obj, node);
        n++;
    }
    
    public Object pop(){
        Node vr = node;
        node = node.objPred;
        n--;
        return vr;
    }
    
    public int size(){
        return n;
    }
    
}
