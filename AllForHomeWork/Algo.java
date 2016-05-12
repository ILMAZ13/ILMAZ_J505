///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package algo;
//
//import java.util.Arrays;
//
///**
// *
// * @author ILMAZ
// */
//public class Algo {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Ver[] a = new Ver[2];
//        a[0] = new Ver();
//        a[0].met = 1;
//        a[1] = new Ver();
//        Arrays.sort(a);
//        System.out.println(a[0].met + " " + a[1].met);
//        
//    }
//    
//    static class Ver implements Comparable<Ver>{
//        public int met = -1;
//
//        @Override
//        public int compareTo(Ver o) {
//            return met == -1 ? 1 : Integer.compare(met, o.met);
//        }
//    }
//}
