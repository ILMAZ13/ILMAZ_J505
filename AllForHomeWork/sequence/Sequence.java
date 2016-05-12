/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence;

import java.util.Arrays;
import java.util.Comparator;
import sequence.Sequence.WeightCom;

/**
 *
 * @author ILMAZ
 */
public class Sequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Product[] prod = new Product[20];
        String[] str = {"Nokia", "Apple","ZTE", "LG", "Sony"};
        for(int i = 0; i < 20; i++){
            prod[i] = new Product(str[Math.abs((int)Math.round(Math.random()*4))], Math.abs((int)Math.round(Math.random()*1000)));
        }
        for(Product p: prod){
            System.out.println(p.getName() + "  " + p.getWeight());
        }
        Arrays.sort(prod, new WeightCom());
        System.out.println("________SORTED_______W");
        for(Product p: prod){
            System.out.println(p.getName() + "  " + p.getWeight());
        }
        Arrays.sort(prod, new NameCom());
        System.out.println("________SORTED_______N");
        for(Product p: prod){
            System.out.println(p.getName() + "  " + p.getWeight());
        }
    }
    static class WeightCom implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
        
    }
    static class NameCom implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o1.getName());
        }
        
    }
    
}
