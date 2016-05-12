/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;

/**
 *
 * @author ILMAZ
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("C:/Users/ILMAZ/Pictures/Library.txt");
        LibraryGenerator lG = new LibraryGenerator(file, 8, 10, false, true, true);
        lG.start();
    }
    
}
