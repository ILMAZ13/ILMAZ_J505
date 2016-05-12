/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.util.Iterator;

/**
 *
 * @author ILMAZ
 */
class EAIterator<T> implements Iterator<Integer>{
    
    private Integer[] products; 
    private int current = -1;

    public EAIterator(Integer[] products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return products.length > current+1;
    }

    @Override
    public Integer next() {
        current++;
        return products[current];
        
    }
    
}
