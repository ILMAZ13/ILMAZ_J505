/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcollection;

import java.util.Dictionary;


/**
 *
 * @author ILMAZ
 * @param <K>
 * @param <T>
 */
public class Dictonary<K, T> {

    
    private int size = 0; 
    private Node node = new Node(null, null, null);
    class Node{
        public K k;
        public T t;
        public Node n;
        public Node(K k, T t, Node n){
            this.k = k;
            this.t = t;
            this.n = n;
        }
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        Node temp = node;
        for(int i = 0; i < size; i++){
            if(temp.k.equals(key)){
                return true;
            }
            temp = temp.n;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        Node temp = node;
        for(int i = 0; i < size; i++){
            if(temp.t.equals(value)){
                return true;
            }
            temp = temp.n;
        }
        return false;
    }

    public T get(Object key) {
        Node temp = node;
        for(int i = 0; i < size; i++){
            if(temp.k.equals(key)){
                return  temp.t;
            }
            temp = temp.n;
        }
        return null;
    }

    public void put(K key, T value) {
        node = new Node(key, value, node);
        size++;
    }

    public T remove(Object key) {
        Node temp = node;
        if (node.k.equals(key)){
            T tempT = temp.t;
            node = node.n;
            size--;
            return tempT;
        }
        Node temp2 = temp.n;
        for(int i = 1; i < size; i++){
            if(temp2.k.equals(key)){
                T tempT = (T) temp.t;
                temp.n = temp2.n;
                size--;
                return tempT;
            }
            temp = temp.n;
            temp2 = temp2.n;
        }
        return null;
    }


    public void clear() {
        node = new Node(null,null,null);
        size = 0;
    }

}
