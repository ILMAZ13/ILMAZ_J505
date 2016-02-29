/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endlessarrayv2;

import java.util.Iterator;

/**
 *
 * @author ILMAZ
 */
public class EndlessArrayIterator<T> implements Iterator<T>{

    private int state = 0;
    private T[] a;
    
    public EndlessArrayIterator(T[] o){
        a = o;
    }
    
    @Override
    public boolean hasNext() {
        return state < a.length ;
    }

    @Override
    public T next() {
        T ff = a[state];
        while(ff == null){
            state++;
            ff = a[state];
        }
        state++;
        return ff;
    }
    
    @Override
    public void remove() {
        a[state-1] = null;
    }
    
    
}
