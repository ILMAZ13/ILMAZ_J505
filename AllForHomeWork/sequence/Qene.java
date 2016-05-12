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
public class Qene {
    private int first;
    private int last;
    private Object[] a;
    
    public Qene(){
        first = 0;
        a = new Object[1000];
        last = 0;
    }
    
    public void push(Object obj){
        a[last] = obj;
        last++;
    }
    
    public Object pop(){
        first++;
        return a[first-1];
    }
    
    public int size(){
        return last- first;
    }
    
}
