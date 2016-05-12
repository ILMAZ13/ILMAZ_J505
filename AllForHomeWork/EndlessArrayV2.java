/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endlessarrayv2;

import java.util.Arrays;

/**
 *
 * @author ILMAZ
 */
public class EndlessArrayV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CollectionV2<String> col = new CollectionV2<>();
        for(int i = 0; i < 10; i++){
            String s = "";
            for(int j = 0; j < Math.abs((int) Math.round(Math.random()*9 + 1)); j++){
                s = s + (char) Math.abs((int) Math.round(Math.random() * ('Z' - 'A') + 'A'));
            }
            col.add(s);
        }
        System.out.println(Arrays.toString(col.toArray()));
        System.out.println(col.toArray()[4]);
        col.remove(col.toArray()[4]);
        System.out.println(Arrays.toString(col.toArray()));
    }
    
}
