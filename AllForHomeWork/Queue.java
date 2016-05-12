/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

/**
 *
 * @author ILMAZ
 */
public class Queue {
    private Node node;
    private Node nodeFirst;
    private int n = 0;
    
    class Node {
        public Object obj;
        public Node objSled;
        public Node(Object obj, Node objPred){
            this.obj = obj;
            this.objSled = objPred;
        }
    }
    
    public Queue(){
        node = new Node(null, null);
        nodeFirst = node;
    }
    
    public void push(Object obj){
        node.obj = obj;
        Node vr = new Node(null, null);
        node.objSled = vr;
        node = vr;
        n++;
    }
    
    public Object pop(){
        Node vr = nodeFirst;
        nodeFirst = nodeFirst.objSled;
        n--;
        return vr.obj;
    }
    
    public int size(){
        return n;
    }
}
