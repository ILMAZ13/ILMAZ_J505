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
public class EA  implements Iterable<Integer>{
    public static void main(String[] args) {
        EA ea = new EA();
        for(int product:ea){
            System.out.println(product);
        }
    }
    
    private Integer[] products = new Integer[10];
    
    public EA(){
        for(int i=0;i<10;i++){
            products[i] = i*i;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new EAIterator<Integer>(products);
    }
}
