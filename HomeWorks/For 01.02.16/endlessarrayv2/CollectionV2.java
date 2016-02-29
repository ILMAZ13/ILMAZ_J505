/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endlessarrayv2;

import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Iterator;

/**
 *
 * @author ILMAZ
 * @param <T>
 */
public class CollectionV2<T> extends AbstractCollection<T>{

    private T[]         a    = (T[]) new Object[0]; 
    private Integer     size = 0;
    private Iterator<T> iter;
    
    @Override
    public Iterator<T> iterator() {
        iter = new EndlessArrayIterator<>(a);
        return iter;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean add(T o) {
        size++;
        T[] b = (T[]) new Object[a.length+1];
        System.arraycopy(a, 0, b, 0, a.length);
        b[a.length] = o;
        a = b;
        return true;
    }
    
}
