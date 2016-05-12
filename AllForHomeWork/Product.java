/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.util.Comparator;

/**
 *
 * @author ILMAZ
 */
public class Product implements Comparable<Product>{
    private final String name;
    private final int weight;
    
    public Product(String name, int cc){
        this.name = name;
        this.weight = cc;
    }
    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName()) == 0 ? 
                Integer.compare(this.getWeight(),o.getWeight()) : 
                this.getName().compareTo(o.getName());
    }
    
    public int getWeight(){
        return weight;
    }
    
    public String getName(){
        return name;
    }
    
}
