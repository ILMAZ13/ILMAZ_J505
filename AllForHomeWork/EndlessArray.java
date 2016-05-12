/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endlessarrayv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ILMAZ
 */
public class EndlessArray<T> implements Iterable<T>{

    private T[] a ;
    private final Iterator<T> eAI;
    private Integer size;
    
    public EndlessArray(){
        a = (T[]) new Object[0];
        size = 0;
        eAI = new EndlessArrayIterator<>(a);
    }
    
    public void add(T o){
        size++;
        T[] b = (T[]) new Object[a.length+1];
        System.arraycopy(a, 0, b, 0, a.length);
        b[b.length] = o;
        a = b;
    }   
    
    public void del(T o){
        size--;
        for(T i : a){
            if (i.equals(o)){
                i = null;
                size--;
                break;
            }
        }
    }
    
    public T[] getArray(){
        return a;
    }
    
    public int getSize(){
        return size;
    }
    
    @Override
    public Iterator<T> iterator() {
        return eAI;
    }
    
}
