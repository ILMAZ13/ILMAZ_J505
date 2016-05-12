/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcollection;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ILMAZ
 */
public class StackCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < 10; i++){
            String s = "";
            for(int j = 0; j < Math.abs((int) Math.round(Math.random() * 9 + 1)); j++){
                s += (char) Math.abs((int) Math.round(Math.random() * ('Z' - 'A') + 'A'));
            }
            stack.push(s);
        }
        System.out.println(Arrays.toString(stack.toArray()));
    }
    
}
