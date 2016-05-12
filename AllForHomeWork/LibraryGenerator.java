/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ILMAZ
 */
public class LibraryGenerator {
    private FileWriter fileWr;
    private int minLength;
    private int maxLength;
    private String letter;
    private String str;
    private int[] pos;
    
    public LibraryGenerator(File file, int minLength, int maxLength, boolean AZ, boolean az, boolean num){
        this.maxLength = maxLength;
        this.minLength = minLength;
        try {
            fileWr = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println("Can`t open file");
        }
        letter = "";
        if(num){
            for(int i = 0; i <= 9; i++){
                letter += i;
            }
        }
        if(az){
            for(int i = (int) 'a'; i <= (int) 'z'; i++){
                letter += (char) i;
            }
        }
        if(AZ){
            for(int i = (int)'A'; i <=(int)'Z' ; i++){
                letter += (char) i;
            }
        }
        System.out.println(letter);
    }
    
    public void start(){
        for(int i = minLength; i <= minLength + (maxLength - minLength); i++){
            pos = new int[i];
            while(pos[0] < letter.length()){
                str = "";
                for(int k : pos){
                    str += letter.charAt(k);
                }
                try {
                    fileWr.write(str + "\n");
                } catch (IOException ex) {
                    System.out.println("Can`t write");
                }
//                System.out.println(str);
                pos[pos.length-1]++;
                reg(pos, pos.length-1);
            }
        }
    }
    
    private void reg(int[] pos, int n){
        if(pos[n] == letter.length()){
            if(n > 0){
                if(pos[n-1] == 0){
                    System.out.println(str);
                }
                pos[n] = 0;
                pos[n-1]++;
                reg(pos, n-1);
            }
        }
    }
}
